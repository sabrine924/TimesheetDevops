package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.MissionRepository;

@Service
public class MissionServiceImpl implements IMissionServiceImpl {

	@Autowired
	 MissionRepository  missionRepository;
	
	@Override
	public Mission getMissionById(int missionId) {
		

		return missionRepository.findById((int) missionId).get();
	}
	
	
	@Override
	public List<Mission> getAllMissions() {
		return (List<Mission>) missionRepository.findAll();
	}
	
	public int ajouterMission(Mission mission) {
		missionRepository.save(mission);
		return mission.getId();
	}
	
	@Transactional
	public void deleteMissionById(int missionId) {
		missionRepository.delete(missionRepository.findById(missionId).get());	
	}
	
	public void deleteAllMissionJPQL() {
        missionRepository.deleteAllMissionJPQL();
	}
}
