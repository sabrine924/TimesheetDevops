package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Contrat;

public interface IContratserviceImpl {
	
	public Contrat getContratById(int contratId);
	public List<Contrat> getAllContrats();
	
	

}
