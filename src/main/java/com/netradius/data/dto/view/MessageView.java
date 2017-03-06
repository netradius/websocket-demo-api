package com.netradius.data.dto.view;

import lombok.Data;

import java.util.Date;

/**
 * View object for Message views.
 *
 * @author Kevin Hawkins
 */
@Data
public class MessageView {
	private String username;
	private String message;
	private Date dateTime;
}
