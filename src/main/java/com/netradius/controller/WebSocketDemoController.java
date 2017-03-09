package com.netradius.controller;

import com.netradius.data.dto.form.MessageRequest;
import com.netradius.data.dto.view.MessageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Controller for request.
 *
 * @author Kevin Hawkins
 */
@Controller
public class WebSocketDemoController {

	@Autowired
	private SimpMessagingTemplate template;

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


	//This is an example of using the simple messaging template to send websocket responses to subscribed clients
	// from a normal http ajax request
	@CrossOrigin
	@RequestMapping(value = "/ping", method = RequestMethod.POST)
	@ResponseBody
	public void pingUsers(@RequestBody MessageRequest request) {
		MessageView messageView = new MessageView();
		messageView.setMessage(generateMeme());
		messageView.setDateTime(new Date());
		messageView.setUsername(request.getUsername());
		template.convertAndSend("/topic/messages", messageView);
	}

	private String generateMeme() {
		List<String> memes = new ArrayList<>();
		memes.add("Cash me on da outside how bout dah!");
		memes.add("Thug life!");
		memes.add("#totes");
		memes.add("YOLO!");
		memes.add("...said no one ever!");
		memes.add("Baller!");
		return memes.get((int) Math.floor(Math.random() * memes.size()));
	}
}
