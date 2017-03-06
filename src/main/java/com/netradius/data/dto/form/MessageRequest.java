package com.netradius.data.dto.form;

import lombok.Data;

/**
 * Simple form object to handle connection requests.
 *
 * @author Kevin Hawkins
 */
@Data
public class MessageRequest {
	private String username;
	private String message;
}
