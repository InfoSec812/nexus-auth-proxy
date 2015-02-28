package com.zanclus.nexus.auth.proxy.rest;

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

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author dphillips
 */
public class LoginTest {

    private LoginInterface login;

    @Test
    public void testNexusLogin() {
        assertTrue("For the given credentials, the validateCredentials method MUST return TRUE", login.validateCredentials("correct", "password"));
    }
}