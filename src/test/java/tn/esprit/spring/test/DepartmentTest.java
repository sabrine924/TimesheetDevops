package tn.esprit.spring.test;
import static org.junit.Assert.*;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.services.IDepartement;



@RunWith(SpringRunner.class)
@SpringBootTest

public class DepartmentTest {
@Autowired
IDepartement deptService;

private static final Logger l = LogManager.getLogger(DepartmentTest.class);
///testtt
@Test
public void testaddandgetDepartement() {
	Departement dept1= new Departement();
	dept1.setName("Eya");
	Departement dept2 = deptService.addDepartement(dept1);
	System.out.println(dept2.getId());
Departement dept = deptService.getDepartementById(dept2.getId());
System.out.println(dept.getId());
assertEquals(dept2.getId(), dept.getId());
deptService.deleteDepartement(dept2.getId());
l.info("success ");
}
@Test
public void testupdateDepartement(){
	Departement dept1= new Departement();
	dept1.setName("Eya");
	Departement dept2 = deptService.addDepartement(dept1);
	dept2.setName("Oumayma");
	Departement dept3 = deptService.updateDepartement(dept2);
	assertEquals(dept3.getName(), dept2.getName());
	assertNotNull(dept3);
	deptService.deleteDepartement(dept3.getId());
}
}


