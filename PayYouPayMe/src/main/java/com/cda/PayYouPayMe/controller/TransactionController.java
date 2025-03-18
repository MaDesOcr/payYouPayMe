package com.cda.PayYouPayMe.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cda.PayYouPayMe.model.Utilisateur;
import com.cda.PayYouPayMe.service.TransactionService;

@Controller
public class TransactionController {

	private final TransactionService transactionService;

	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}

	@GetMapping("/me/user")
	public String getCurrentUser() {
		Utilisateur utilisateur = transactionService.getCurrentUser();
		System.out.println("user : " +utilisateur);

		return null;
				}
}
