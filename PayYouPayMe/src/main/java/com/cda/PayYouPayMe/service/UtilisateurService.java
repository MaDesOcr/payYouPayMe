package com.cda.PayYouPayMe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cda.PayYouPayMe.model.Utilisateur;
import com.cda.PayYouPayMe.repository.UtilisateurRepository;

@Service
public class UtilisateurService {

	private final UtilisateurRepository utilisateurRepository;
    private final AuthentificationService authService;

	public UtilisateurService(UtilisateurRepository utilisateurRepository,
			AuthentificationService authService) {
		this.utilisateurRepository = utilisateurRepository;
		this.authService = authService;
	}

    public Utilisateur getCurrentUser() {
        String username = authService.getCurrentUsername();
        if (username != null) {
            Optional<Utilisateur> utilisateur = utilisateurRepository.findByUsername(username);
            return utilisateur.orElse(null);
        }
        return null;
    }
	
	
	public List<Utilisateur> getAllUtilisateurs() {
		
		return this.utilisateurRepository.findAll();
	}

	public void updateUser(Utilisateur userToSave) {
		Utilisateur utilisateurToModify = getCurrentUser();
		utilisateurToModify.setFirstName(userToSave.getFirstName());
		utilisateurToModify.setLastName(userToSave.getLastName());
		utilisateurToModify.setEmail(userToSave.getEmail());
		utilisateurRepository.save(utilisateurToModify);
	
	}
}
