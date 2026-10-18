package org.jsp.onetomany;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindEmpByIdFindMeth {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Id : ");
		Employee e = em.find(Employee.class, sc.nextInt());
		if(e!=null) {
			System.out.println(e);
		}
		else {
			System.err.println("No Record found !!!");
		}
		try {}
		finally {
			sc.close();
		}
	}
}
