package org.jsp.onetomany;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindEmpByDeptIdAndName {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		Query q = em.createQuery("select d.elist from Dept d where d.id = ?1 and d.name = ?2");
		System.out.println("Enter Dept Id : ");
		q.setParameter(1, sc.nextInt());
		System.out.println("Enter Dept Name : ");
		q.setParameter(2, sc.next());
		@SuppressWarnings("unchecked")
		List<Employee> el = q.getResultList();
		if(!el.isEmpty()) {
			el.forEach(System.out::println);
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
