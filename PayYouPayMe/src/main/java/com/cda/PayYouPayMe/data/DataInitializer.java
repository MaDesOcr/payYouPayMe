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
			u1.setIban("monIBAN");
			u1.setEmail("test@test.com");
		//	u1.setPassword(passwordEncoder.encode("user"));
			u1.setBalance(30f);
			utilisateurRepository.save(u1);

			Utilisateur u2 = new Utilisateur();
			u2.setFirstName("firstNameU2");
			u2.setLastName("LastNameU2");
			u2.setUsername("user");
		//	u2.setPassword(passwordEncoder.encode("user"));
			u2.setLogin("usertest");
			u2.setIban("monIBAN");
			u2.setEmail("test@test.com");
			u2.setBalance(20f);
			utilisateurRepository.save(u2);

			Utilisateur u3 = new Utilisateur();
			u3.setFirstName("firstNameU3");
			u3.setLastName("LastNameU3");
			u3.setUsername("user");
		//	u3.setPassword(passwordEncoder.encode("user"));
			u3.setLogin("usertest");
			u3.setIban("monIBAN");
			u3.setEmail("test@test.com");
			u3.setBalance(20f);
			utilisateurRepository.save(u3);

			u1.getContact().add(u2);
			
			utilisateurRepository.save(u1);

			
			Transaction t1 = new Transaction(20f, "pour les courses", LocalDate.now());
			t1.setSender(u1);
			t1.setReciever(u2);
			transactionRepository.save(t1);

			Transaction t2 = new Transaction(30f, "Transation 2", LocalDate.now());
			t2.setSender(u2);
			t2.setReciever(u1);
			transactionRepository.save(t2);
			
			Transaction t3 = new Transaction(20f, "Transaction 3", LocalDate.now());
			t3.setSender(u1);
			t3.setReciever(u2);
			transactionRepository.save(t3);
			
			Message m1 = new Message("message 1", LocalDate.now());
			m1.setUtilisateur(u1);
			messageRepository.save(m1);
			
			Message m3 = new Message("message 3", LocalDate.now());
			m3.setUtilisateur(u1);
			messageRepository.save(m3);
			
			Message m2 = new Message("message 2", LocalDate.now());
			m2.setUtilisateur(u2);
			messageRepository.save(m2);
		};
	}

}
