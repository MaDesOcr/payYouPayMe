package com.cda.PayYouPayMe.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cda.PayYouPayMe.model.Message;
import com.cda.PayYouPayMe.repository.MessageRepository;

@Service
public class MessageService {

	private final MessageRepository messageRepository;

	public MessageService(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	public List<Message> getAllMessages() {
		return this.messageRepository.findAll();
	}
}
