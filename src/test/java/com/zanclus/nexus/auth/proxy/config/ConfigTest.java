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
