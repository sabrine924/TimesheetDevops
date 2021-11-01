package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Mission;


public interface MissionRepository extends CrudRepository<Mission, Integer> {

	@Modifying
    @Transactional
    @Query("DELETE from Mission")
    public void deleteAllMissionJPQL();
}
