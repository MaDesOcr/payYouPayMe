package com.cda.PayYouPayMe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cda.PayYouPayMe.service.MessageService;
import com.cda.PayYouPayMe.service.TransactionService;
import com.cda.PayYouPayMe.service.UtilisateurService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	private final MessageService messageService;
	private final TransactionService transactionService;
	private final UtilisateurService utilisateurService;
	
	public AdminController(MessageService messageService,
			TransactionService transactionService,
			UtilisateurService utilisateurService) {
		this.messageService = messageService;
		this.transactionService = transactionService;
		this.utilisateurService = utilisateurService;
	}
	
	
	
	@GetMapping("/")
	public String getHello() {
		return "hello";
	}
	
	@GetMapping("/alldatas")
	public String getAllDatas(Model model) {
		model.addAttribute("messages", messageService.getAllMessages());
		model.addAttribute("transactions", transactionService.getAllTransactions());
		model.addAttribute("utilisateurs", utilisateurService.getAllUtilisateurs());
		return "alldatas";
	}
	
	
	
	
	
}
