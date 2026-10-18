package org.jsp.onetomany;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class FindEmpBySal {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		TypedQuery<Employee> q = em.createQuery("select e from Employee e where e.salary = ?1", Employee.class);
		System.out.println("Enter Employee Salary : ");
		q.setParameter(1, sc.nextDouble());
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
