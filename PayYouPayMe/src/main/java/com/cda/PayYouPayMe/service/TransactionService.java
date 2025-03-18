package com.cda.PayYouPayMe.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cda.PayYouPayMe.model.Transaction;
import com.cda.PayYouPayMe.repository.TransactionRepository;

@Service
public class TransactionService {

	private final TransactionRepository transactionRepository;

	public TransactionService(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}

	public List<Transaction> getAllTransactions() {
		
		return this.transactionRepository.findAll();
	}
}