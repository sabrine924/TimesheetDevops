package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;
import tn.esprit.spring.entities.Societe;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.repository.SocieteRepository;

@Service
public class SocieteServiceImpl implements ISocieteService {
	@Autowired
	MissionRepository missionRepository;
	@Autowired
	SocieteRepository societeRepository;
	public int ajouterSociete(Societe societe) {
		societeRepository.save(societe);
		return societe.getId();
	}

	public int ajouterMission(Mission mission) {
		missionRepository.save(mission);
		return mission.getId();
	}
	
	public void affecterMissionASociete(int missionId, int societeId) {
		//Le bout Master de cette relation N:1 est departement  
				//donc il faut rajouter la societe a mission 
				// ==> c'est l'objet mission(le master) qui va mettre a jour l'association
				//Rappel : la classe qui contient mappedBy represente le bout Slave
				//Rappel : Dans une relation oneToMany le mappedBy doit etre du cote one.
				Societe societeManagedEntity = societeRepository.findById(societeId).get();
				Mission missionManagedEntity = missionRepository.findById(missionId).get();
				
				missionManagedEntity.setSociete(societeManagedEntity);
				societeRepository.save(societeManagedEntity);
		
	}
	
	public List<String> getAllMissionsNamesBySociete(int societeId) {
		Societe societeManagedEntity = societeRepository.findById(societeId).get();
		List<String> missionNames = new ArrayList<>();
		for( Mission mission : societeManagedEntity.getMissions()){
			missionNames.add(mission.getName());
		}
		
		return missionNames;
	}

	@Transactional
	public void deleteSocieteById(int societeId) {
		if(societeRepository.findById(societeId).isPresent()){
		societeRepository.delete(societeRepository.findById(societeId).get());}	
	}

	@Transactional
	public void deleteMissionById(int depId) {
		if(missionRepository.findById(depId).isPresent()){
		missionRepository.delete(missionRepository.findById(depId).get());	}
	}


	public Societe getSocieteById(int societeId) {
		if(societeRepository.findById(societeId).isPresent()){
		return societeRepository.findById(societeId).get();	}
		return null;
	}



}
