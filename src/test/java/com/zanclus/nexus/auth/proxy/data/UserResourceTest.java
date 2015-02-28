package com.zanclus.nexus.auth.proxy.data;

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

import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author dphillips
 */
public class UserResourceTest {

    private UserResourceInterface res;

    @Test
    public void testCreateUserToken() {
        String token = res.createUserToken("testuser");
        assertNotNull("The token MUST NOT be NULL", token);
        assertTrue("The token MUST be of sufficient length", token.length()>10);
    }

    @Test
    public void testValidateToken() {
        String username = res.validateToken("TESTTOKEN");
        assertNotNull("Username MUST NOT be NULL", username);
    }

    @Test
    public void testDeleteToken() {
        boolean result = res.deleteToken("username", "tokenstring");
        assertTrue("Deleting a valid token MUST return TRUE", result);
    }

    @Test
    public void testGetTokensForUser() {
        List<String> tokens = res.getTokensForUser("username");
        assertNotNull("The returned list MUST NOT be NULL", tokens);
        assertTrue("The length of the list MUST be 3", tokens.size()==3);
        assertEquals("The first token MUST equal 'testtoken1'", tokens.get(0), "testtoken1");
        assertEquals("The second token MUST equal 'testtoken2'", tokens.get(1), "testtoken2");
        assertEquals("The third token MUST equal 'testtoken3'", tokens.get(2), "testtoken3");
    }
}
