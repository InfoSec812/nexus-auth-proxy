package com.zanclus.nexus.auth.proxy;

import com.beust.jcommander.JCommander;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zanclus.nexus.auth.proxy.config.Config;
import java.lang.reflect.Field;
import java.nio.file.Files;
import lombok.extern.slf4j.Slf4j;

/*
 * #%L
 * nexus-auth-proxy
 * %%
 * Copyright (C) 2015 Zanclus Consulting
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

/**
 * Entry-point for Nexus Authentication Proxy server.
 * @author <a href="https://github.com/InfoSec812/">Deven Phillips</a>
 */
@Slf4j
public class Main {

    /**
     * Given a source and destination instance of {@link Config}, copy the non-null values from source into destination
     * @param src The instance of {@link Config} to copy non-null values from
     * @param dst The instance of {@link Config} to copy non-null values to
     * @throws Exception If there is a problem doing the reflection work
     */
    private static void mergeConfigs(Config src, Config dst) throws Exception {
        for (Field field: src.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.get(src)!=null) {
                field.set(dst, field.get(src));
            }
            field.setAccessible(false);
        }
    }

    public static void main(String[] args) throws Exception {
        Gson gson = (new GsonBuilder())
                            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                            .setPrettyPrinting()
                            .excludeFieldsWithoutExposeAnnotation()
                            .create();
        Config params = new Config();
        JCommander commander = new JCommander(params);
        commander.setAcceptUnknownOptions(true);
        commander.setProgramName("nexus-auth-proxy");
        commander.parse(args);
        if (params.help()) {
            commander.usage();
            System.exit(0);
        }
        LOG.debug("Parsed command-line args: \n\n"+gson.toJson(params)+"\n\n");
        if (params.configFile().isFile() && params.configFile().canRead()) {
            Config fileCfg = gson.fromJson(new String(Files.readAllBytes(params.configFile().toPath())), Config.class);
            mergeConfigs(params, fileCfg);
            params = fileCfg;
        }
        params.fillDefaults();
        LOG.debug("Loaded Config:\n\n"+gson.toJson(params)+"\n\n");
    }
}
