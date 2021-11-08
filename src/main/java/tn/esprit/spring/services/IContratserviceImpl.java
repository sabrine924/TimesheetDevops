package tn.esprit.spring.services;

import java.util.List;


import tn.esprit.spring.entities.Contrat;

public interface IContratserviceImpl {
	
	public  Contrat  getContratById(int contratId);
	public List<Contrat> getAllContrats();
	
	

}
