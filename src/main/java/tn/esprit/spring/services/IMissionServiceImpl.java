package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;

public interface IMissionServiceImpl {

	
	public  Mission  getMissionById(int missionId);
	public List<Mission> getAllMissions();
	public int ajouterMission(Mission mission);
	public void deleteMissionById(int missionId);
}
