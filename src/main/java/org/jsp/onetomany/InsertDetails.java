package org.jsp.onetomany;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InsertDetails {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		EntityTransaction etran = em.getTransaction();
		etran.begin();
		
		Dept d1 = new Dept();
		d1.setName("HR");
		d1.setLocation("BTM");
		
		Dept d2 = new Dept();
		d2.setLocation("HSR");
		d2.setName("Accounts");
		
		Employee e1 = new Employee();
		e1.setName("A");
		e1.setSalary(15000);
		
		Employee e2 = new Employee();
		e2.setName("B");
		e2.setSalary(16000);
		
		Employee e3 = new Employee();
		e3.setName("C");
		e3.setSalary(17000);
		
		Employee e4 = new Employee();
		e4.setName("D");
		e4.setSalary(19000);
		
		Employee e5 = new Employee();
		e5.setName("E");
		e5.setSalary(20000);
		
		List<Employee> el1 = Arrays.asList(e1,e3,e5);
		List<Employee> el2 = Arrays.asList(e2,e4);
		
		d1.setElist(el1);
		d2.setElist(el2);
		
		List<Dept> dl = Arrays.asList(d1,d2);
		
		for(Dept d : dl) {
			em.persist(d);
		}
		
		etran.commit();
	}
}
