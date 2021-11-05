package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Societe;
import tn.esprit.spring.services.SocieteServiceImpl;

@RestController
public class RestControlISociete {
	@Autowired
	SocieteServiceImpl societeServiceImpl;
	
	@PostMapping("/ajouterSociete")
	@ResponseBody
	public Societe ajouterEmploye(@RequestBody Societe societe)
	{
		societeServiceImpl.ajouterSociete(societe);
		
		return societe;
	}

}
