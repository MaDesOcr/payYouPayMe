package com.cda.PayYouPayMe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cda.PayYouPayMe.model.Utilisateur;
import com.cda.PayYouPayMe.repository.UtilisateurRepository;

@Service
public class UtilisateurService {

	private final UtilisateurRepository utilisateurRepository;

	public UtilisateurService(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}

	public List<Utilisateur> getAllUtilisateurs() {
		return this.utilisateurRepository.findAll();
	}
}
