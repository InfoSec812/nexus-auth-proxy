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

/**
 *
 * @author <a href="https://github.com/InfoSec812/">Deven Phillips</a>
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
