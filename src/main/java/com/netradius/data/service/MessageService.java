package com.netradius.data.service;

import javax.validation.constraints.NotNull;

/**
 * Service to handle logic for messaging.
 *
 * @author Kevin Hawkins
 */
public interface MessageService {

	boolean connectUser(@NotNull String username);
}
