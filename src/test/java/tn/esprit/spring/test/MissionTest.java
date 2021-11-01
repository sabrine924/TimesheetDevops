package tn.esprit.spring.test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.services.EmployeServiceImpl;
import tn.esprit.spring.services.MissionServiceImpl;

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
public class MissionTest {
	
	@Autowired
	MissionRepository missionRepoistory;
	@Autowired
	MissionServiceImpl missionServiceImpl;
	
	private static final Logger l = LogManager.getLogger(ContratTest.class);

	
	/*@Test
	public void TestAjouterMission() throws ParseException {
		
		Mission mission = new Mission("d", "web"); //nom de contrat d et descrption web 
		int idmission = missionServiceImpl.ajouterMission(mission);

		assertEquals(6, idmission);
	}*/
	/*@Test
	public void TestDeleteMissionById() {
		Mission mission = missionRepoistory.findById(1).get();
		
		
		if(mission.getId()!=0) {
	    	
			missionServiceImpl.deleteMissionById(1);
			assertThat(missionRepoistory.existsById(1)).isFalse();//confirm that mission has beeen deleted
	    	 }
	    	 else {
	    		 assertNull(mission);
	    	 }
	
	}*/
	@Test
	public void TestdeleteAllMissionJPQL() {
		missionServiceImpl.deleteAllMissionJPQL();
		List<Mission> mission = (List<Mission>) missionRepoistory.findAll();
		assertEquals(0, mission.size());
	}
	/*@Test
	public void testGetListMissions() {
		ArrayList<Mission> Missions = (ArrayList<Mission>) missionServiceImpl.getAllMissions();
		assertThat(Missions.size()).isPositive();
	}*/
}
