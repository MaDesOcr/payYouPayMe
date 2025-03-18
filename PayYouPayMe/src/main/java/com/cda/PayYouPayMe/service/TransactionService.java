package com.cda.PayYouPayMe.service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cda.PayYouPayMe.model.Transaction;
import com.cda.PayYouPayMe.model.Utilisateur;
import com.cda.PayYouPayMe.repository.TransactionRepository;
import com.cda.PayYouPayMe.repository.UtilisateurRepository;

@Service
public class TransactionService {

	private final TransactionRepository transactionRepository;
    private final AuthentificationService authService;
    private final UtilisateurRepository utilisateurRepository;
    
	public TransactionService(TransactionRepository transactionRepository,
			AuthentificationService authService,
			UtilisateurRepository utilisateurRepository) {
		this.transactionRepository = transactionRepository;
		this.authService = authService;
		this.utilisateurRepository = utilisateurRepository;
	}

	public List<Transaction> getAllTransactions() {
		
		return this.transactionRepository.findAll();
	}
	
    public Utilisateur getCurrentUser() {
        String username = authService.getCurrentUsername();
        if (username != null) {
            Optional<Utilisateur> utilisateur = utilisateurRepository.findByLogin(username);
            return utilisateur.orElse(null);
        }
        return null;
    }
    
    public List<Transaction> getCurrentUserTransactions() {
        String username = authService.getCurrentUsername();
        if (username != null) {
            return transactionRepository.findAllByUserLogin(username);
        }
        return Collections.emptyList();
    }
    
    public List<Transaction> getUserTransactions(Integer userId) {
        Optional<Utilisateur> utilisateur = utilisateurRepository.findById(userId);
        return utilisateur.map(u -> transactionRepository.findAllByUser(u))
                         .orElse(Collections.emptyList());
    }
}