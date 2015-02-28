package com.zanclus.nexus.auth.proxy.data;

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

import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author <a href="https://github.com/InfoSec812/">Deven Phillips</a>
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
