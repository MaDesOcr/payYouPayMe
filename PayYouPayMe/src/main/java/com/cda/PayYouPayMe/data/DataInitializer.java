package com.cda.PayYouPayMe.data;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.cda.PayYouPayMe.model.Message;
import com.cda.PayYouPayMe.model.Transaction;
import com.cda.PayYouPayMe.model.Utilisateur;
import com.cda.PayYouPayMe.repository.MessageRepository;
import com.cda.PayYouPayMe.repository.TransactionRepository;
import com.cda.PayYouPayMe.repository.UtilisateurRepository;

@Configuration
public class DataInitializer {

	@Bean
	CommandLineRunner initDatabase(UtilisateurRepository utilisateurRepository,
			MessageRepository messageRepository,
			TransactionRepository transactionRepository) {
		return args -> {
			Utilisateur u1 = new Utilisateur();
			u1.setFirstName("firstNameU1");
			u1.setLastName("LastNameU1");
			u1.setUsername("usertest");
			u1.setLogin("usertest");
		//	u1.setPassword(passwordEncoder.encode("user"));
			u1.setBalance(30f);
			utilisateurRepository.save(u1);

			Utilisateur u2 = new Utilisateur();
			u2.setFirstName("firstNameU2");
			u2.setLastName("LastNameU2");
			u2.setUsername("user");
		//	u2.setPassword(passwordEncoder.encode("user"));
			
			u2.setBalance(20f);
			utilisateurRepository.save(u2);

			Transaction t1 = new Transaction(20f, "pour les courses", LocalDate.now());
			t1.setSender(u1);
			t1.setReciever(u2);
			transactionRepository.save(t1);

			Message m1 = new Message("message 1", LocalDate.now());
			m1.setUtilisateur(u2);
			messageRepository.save(m1);
		};
	}

}
