package org.jsp.onetomany;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindDeptByIdFindMeth {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
		EntityManager em = emf.createEntityManager();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Dept Id : ");
		Dept d = em.find(Dept.class, sc.nextInt());
		if(d!=null) {
			System.out.println(d);
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
