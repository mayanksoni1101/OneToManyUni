package org.jsp.onetomany;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FindEmpByDeptAndLoc {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		Query q = em.createQuery("select d.elist from Dept d where d.name = ?1 and d.location = ?2");
		System.out.println("Enter Dept Name : ");
		q.setParameter(1, sc.next());
		System.out.println("Enter Dept Location : ");
		q.setParameter(2, sc.next());
		@SuppressWarnings("unchecked")
		List<Employee> el = q.getResultList();
		for(Employee e : el) {
			System.out.println(e);
		}
		try {}
		finally {
			sc.close();
		}
	}
}
