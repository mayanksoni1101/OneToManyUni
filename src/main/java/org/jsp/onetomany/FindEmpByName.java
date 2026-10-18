package org.jsp.onetomany;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindEmpByName {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Name : ");
		Query q = em.createQuery("select e from Employee e where e.name = ?1");
		q.setParameter(1, sc.next());
		Dept d = (Dept) q.getSingleResult();
		if(d!=null) {
			System.out.println(d);
		}
		else {
			System.err.println("No Record Found !!!");
		}
		try {}
		finally {
			sc.close();
		}
	}
}
