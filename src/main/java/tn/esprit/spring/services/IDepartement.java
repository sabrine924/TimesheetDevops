package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Departement;

public interface IDepartement {
	public  Departement addDepartement(Departement departement);
	public List<Departement> getDepartement();
	public Departement getDepartementById(int id);
	public Departement updateDepartement(Departement departement);
	public void  deleteDepartement(int id);
//tester
}
