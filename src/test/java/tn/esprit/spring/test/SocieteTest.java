package tn.esprit.spring.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Societe;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.SocieteRepository;
import tn.esprit.spring.services.ISocieteService;
@RunWith(SpringRunner.class)
@SpringBootTest()
public class SocieteTest {
	@Autowired
	ISocieteService societeService;
	@Autowired
	SocieteRepository societeRepository;
	@Autowired
	MissionRepository missionRepository;

	@Test
	public void testAddSociete() throws ParseException {
		Societe societe= new Societe("soc");
		societeService.ajouterSociete(societe);
		assertThat(societeService.ajouterSociete(societe)).isGreaterThan(0);
	}
	@Test
	public void testAddMission() throws ParseException {
		Mission mission= new Mission("miss","desc");
		assertThat(societeService.ajouterMission(mission)).isGreaterThan(0);
	}
	@Test(timeout= 5000)
	public void testAffecterMissionASociete(){
		societeService.affecterMissionASociete(1, 1);
		Societe societe= societeRepository.findById(1).get();
		Mission mission= missionRepository.findById(1).get();
		assertTrue(mission.getSociete().equals(societe));
	}
	@Test(timeout= 5000)
	public void testGetAllMissionsNamesBySociete(){
		societeService.affecterMissionASociete(1, 1);
		List<String> list= new ArrayList<String>();
		list=societeService.getAllMissionsNamesBySociete(1);
		assertThat(list).size().isGreaterThan(0);
		
	}
	@Test
	public void testDeleteSocieteById(){
		List<Societe> list= new ArrayList<Societe>();
		list=(List<Societe>) societeRepository.findAll();
		societeService.deleteSocieteById(1);
		List<Societe> listnew= new ArrayList<Societe>();
		listnew=(List<Societe>) societeRepository.findAll();
		assertThat(list).size().isGreaterThan(listnew.size());
	}


}
