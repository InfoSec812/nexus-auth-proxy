package com.zanclus.nexus.auth.proxy.config;

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

import org.junit.Test;
import org.junit.BeforeClass;
import org.meanbean.test.BeanTester;
import org.meanbean.test.EqualsMethodTester;
import org.meanbean.test.HashCodeMethodTester;

/**
 * Unit Tests for the {@link Config} bean
 * @author <a href="https://github.com/InfoSec812">Deven Phillips</a>
 */
public class ConfigTest {

    private static BeanTester beanTester;
    private static EqualsMethodTester eqTester;
    private static HashCodeMethodTester hashTester;

    @BeforeClass
    public static void setup() {
        beanTester = new BeanTester();
        beanTester.setIterations(75);
        eqTester = new EqualsMethodTester();
        hashTester = new HashCodeMethodTester();
    }

    /**
     * Test accessors for {@link Config} bean using meanbean
     */
    @Test
    public void testConfigurationBean() {
        beanTester.testBean(Config.class);
    }

    /**
     * Test {@link Config#equals(java.lang.Object)} using meanbean
     */
    @Test
    public void testConfigEquals() {
        eqTester.testEqualsMethod(Config.class);
    }

    /**
     * Test {@link Config#hashCode()} using meanbean
     */
    @Test
    public void testConfigHashCode() {
        hashTester.testHashCodeMethod(Config.class);
    }
}
