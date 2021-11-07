package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;

@Service
public class DepartementService implements IDepartement {

	@Autowired
	private DepartementRepository dr;

	@Override
	public Departement addDepartement(Departement departement) {
		return this.dr.save(departement);
		
	}

	@Override
	public List<Departement> getDepartement() {
		return (List<Departement>) this.dr.findAll();
	}

	@Override
	public Departement getDepartementById(int id) {
		return this.dr.findById(id).orElse(null);
		
	}

	@Override
	public Departement updateDepartement(Departement departement) {
		if(this.dr.existsById(departement.getId())) {
			return this.dr.save(departement);
		}
		else return null;
	}

	@Override
	public void deleteDepartement(int id) {
		if(this.dr.existsById(id)) {
		this.dr.deleteById(id);
		}
		
	}
	
}
