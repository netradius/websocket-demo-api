package com.netradius.data.service.impl;

import com.netradius.data.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import javax.validation.constraints.NotNull;

/**
 * Class to handle implementation for MessageService.
 *
 * @author Kevin Hawkins
 */
@Service
@Slf4j
public class MessageServiceImpl implements MessageService {



	@Override
	public boolean connectUser(@NotNull String username) {
		return true;
	}
}
