package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Societe;

public interface ISocieteService {
	public int ajouterSociete(Societe societe);
	public int ajouterMission(Mission mission);
	void affecterMissionASociete(int depId, int societeId);
	List<String> getAllMissionsNamesBySociete(int societeId);
	public void deleteSocieteById(int entrepriseId);
	public void deleteMissionById(int depId);
	public Societe getSocieteById(int societeId);

}
