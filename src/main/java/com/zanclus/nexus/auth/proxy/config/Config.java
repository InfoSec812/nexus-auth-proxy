package com.zanclus.nexus.auth.proxy.config;

/*
 * #%L
 * nexus-auth-proxy
 * %%
 * Copyright (C) 2015 Zanclus Consulting
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author dphillips
 */
@Data
@NoArgsConstructor
@Parameters(separators = " =")
public class Config {

    @Parameter(description = "The hostname or IP address on which the proxy to listen for incomming requests.", names = {"--proxy-host"})
    private String proxyInterface;

    @Parameter(description = "Port on which the proxy will listen for incoming requests.", names = {"--proxy-port"})
    private Integer proxyPort;

    @Parameter(description = "The hostname or IP address of the application to be proxied.", names = {"--target-host"})
    private String target;
    
    @Parameter(description = "Port of the application to be proxied.", names = {"--target-port"})
    private Integer targetPort;

    @Parameter(description = "The name of the header which should be set on proxied requests.", names = {"--rut-header"})
    private String rutHeader = "REMOTE_USER";
}
