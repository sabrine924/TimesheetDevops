package tn.esprit.spring.test;
/*
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.services.ContratServiceImpl;
import tn.esprit.spring.services.EmployeServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;


@RunWith(SpringRunner.class)
@SpringBootTest()
*/
public class ContratTest {
	/*@Autowired
	ContratRepository contratRepoistory;
	@Autowired
	EmployeRepository employeRepoistory;
	@Autowired
	EmployeServiceImpl employeServiceImpl;
	@Autowired
	
	ContratServiceImpl icontratservice;
    private static final Logger l = LogManager.getLogger(ContratTest.class);


	@Test
	public void TestAjouterContrat() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2022-10-07"); //date contrat 07 October 2021
		Contrat contrat = new Contrat(d, "CDD", 500); //type de contrat cdd et salaire 500
		int idcontrat = employeServiceImpl.ajouterContrat(contrat);

		assertEquals(1, idcontrat);
	}

	@Test
	public void testAffecterContratAEmployet() {

		employeServiceImpl.affecterContratAEmploye(1,1); //contrat id = 2, employe id= 5
		Employe employe = employeRepoistory.findById(1).get(); 
		int idContrat = employe.getContrat().getReference();
		assertEquals(1, idContrat);

	}
	

	@Test
	public void TestDeleteContratById() {
		Contrat contrat = contratRepoistory.findById(1).get();
		
		
		if(contrat.getReference()!=0) {
	    	
			employeServiceImpl.deleteContratById(3);
			assertThat(employeRepoistory.existsById(1)).isFalse();//confirm that employe has beeen deleted
	    	 }
	    	 else {
	    		 assertNull(contrat);
	    	 }
	
	}
	@Test
	public void TestdeleteAllContratJPQL() {
		employeServiceImpl.deleteAllContratJPQL();
		List<Contrat> contrat = (List<Contrat>) contratRepoistory.findAll();
		assertEquals(0, contrat.size());
	}
	@Test
	public void tesUpdateContrat() {
		Contrat contrat = icontratservice.getContratById(7);
		contrat.setSalaire(2100);
		int contratId = employeServiceImpl.ajouterContrat(contrat);
		Contrat updatedcontrat = icontratservice.getContratById(contratId);
		assertThat(updatedcontrat.getSalaire()).isEqualTo(contrat.getSalaire());
	}
	@Test
	public void testFindContratById() {
		Contrat contrat = icontratservice.getContratById(7);
		assertThat(contrat.getReference()).isEqualTo(7);
	}
	@Test
	public void testGetListContrats() {
		ArrayList<Contrat> entreprises = (ArrayList<Contrat>) icontratservice.getAllContrats();
		assertThat(entreprises.size()).isPositive();
	}*/
}  