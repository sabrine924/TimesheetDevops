package tn.esprit.spring.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.ContratServiceImpl;



@RestController
public class RestControlIContrat {
	
	
	

	@Autowired
	
	ContratServiceImpl icontratservice;
	
	
	@GetMapping("/contrats/retrieveconrat/{contratId}")
	@ResponseBody
	public Contrat retrieveContrat(@PathVariable("contratId") long contratId) {
	return icontratservice.getContratById((int) contratId);
	}
}
	
	