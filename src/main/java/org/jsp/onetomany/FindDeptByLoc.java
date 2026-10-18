package org.jsp.onetomany;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindDeptByLoc {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Dept Location : ");
		Query q = em.createQuery("select d from Dept d where d.location = ?1");
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
