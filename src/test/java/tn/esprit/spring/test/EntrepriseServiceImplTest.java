package tn.esprit.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.EntrepriseServiceImpl;
import tn.esprit.spring.services.IEntrepriseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;


import static org.junit.Assert.assertNotNull;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EntrepriseServiceImplTest {
    private static final Logger  l = LogManager.getLogger(EntrepriseServiceImpl.class);
	@Autowired
    IEntrepriseService entrepriseService;

    Integer a,b;

    @Test
    public void testAjouterEntreprise(){
        
        Entreprise ent=new Entreprise("actia","ariana");
        a= entrepriseService.ajouterEntreprise(ent);
        assertNotNull(a);


    }
    @Test
    public void testGetEntrepriseById(){

        Entreprise ent= entrepriseService.getEntrepriseById(4);

        assertNotNull(ent);

    }
    @Test
    public void testAjouterDepartement(){

        Departement dep=new Departement("ooredoo");
        b=entrepriseService.ajouterDepartement(dep);
        assertNotNull(b);
    }
    @Test
    public void testGetAllDepartementsNamesByEntreprise(){

        List<String> depNames= entrepriseService.getAllDepartementsNamesByEntreprise(4);
        assertNotNull(depNames);
    }
    @Test
    public void testAffecterDepartementAEntreprise(){

        entrepriseService.affecterDepartementAEntreprise(1,4);
       

    }

   /* 
       @Test
    public void testDeleteDepartementById(){
        entrepriseService.deleteDepartementById(13);
    }
    @Test
    public void testDeleteEntrepriseById(){
        entrepriseService.deleteEntrepriseById(1);
    }*/
}

