package com.netradius.controller;

import com.netradius.data.dto.form.MessageRequest;
import com.netradius.data.dto.view.MessageView;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.Date;

/**
 * Controller for request.
 *
 * @author Kevin Hawkins
 */
@Controller
public class WebSocketDemoController {

	@MessageMapping(value = "/add")
	@SendTo("/topic/messages")
	public MessageView addMessage(@RequestBody MessageRequest request) {
		//You can do whatever you need to do here.
		//For demo, we are just going to return a message view to all those subscribed to /messages
		MessageView messageView = new MessageView();
		messageView.setMessage(request.getMessage());
		messageView.setUsername(request.getUsername());
		messageView.setDateTime(new Date());
		return messageView;
	}
}
