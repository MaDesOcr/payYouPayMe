package com.cda.PayYouPayMe.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cda.PayYouPayMe.model.Utilisateur;
import com.cda.PayYouPayMe.service.TransactionService;
import com.cda.PayYouPayMe.service.UtilisateurService;

@Controller
@RequestMapping("/transaction")
public class TransactionController {

	private final TransactionService transactionService;
	private final UtilisateurService utilisateurService;
	
	public TransactionController(TransactionService transactionService,
			UtilisateurService utilisateurService) {
		this.transactionService = transactionService;
		this.utilisateurService = utilisateurService;
	}
	
	
	@GetMapping("/")
	public String getTransaction(Model model) {
		model.addAttribute("utilisateur", utilisateurService.getCurrentUser());
		return "transaction";
	}
	
	@PostMapping("/createtransaction")
	public String createTransaction(Model model,
			@RequestParam String reciever,
			@RequestParam Float amount,
			@RequestParam String content) {
		transactionService.createTransaction(reciever, amount, content);
		model.addAttribute("utilisateur", utilisateurService.getCurrentUser());
		return "transaction";
	}
}
