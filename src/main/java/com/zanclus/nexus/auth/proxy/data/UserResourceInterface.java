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

/**
 *
 * @author dphillips
 */
public interface UserResourceInterface {

    /**
     * Given a username, generate a new unique token, store it in the database
     * and return the token string
     * @param username The username with which to associate the new token
     * @return The token string
     */
    public String createUserToken(String username);

    /**
     * Given a token, see if it exists in the DB and if it does, return the
     * associated username.
     * @param token A token string provided via the "Authorization" header
     * @return A username if the token is valid, otherwise NULL.
     */
    public String validateToken(String token);

    /**
     * Given a username and a token, remove the token from the database.
     * @param username The username the token is associated with.
     * @param token The token to be removed.
     * @return TRUE is successful, otherwise return false.
     */
    public boolean deleteToken(String username, String token);

    /**
     * Return a list of tokens associated with the specified user.
     * @param username The username associated with the tokens to be retrieved
     * @return A {@link List} of {@link String}s containing tokens for the 
     * given username.
     */
    public List<String> getTokensForUser(String username);
}
