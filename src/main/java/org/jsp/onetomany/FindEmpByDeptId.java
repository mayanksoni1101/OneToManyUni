//package org.jsp.onetomany;
//
//import java.util.List;
//import java.util.Scanner;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.Query;
//
//public class FindEmpByDeptId {
//	public static void main(String[] args) {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
//		EntityManager em = emf.createEntityManager();
//		Scanner sc = new Scanner(System.in);
//		Query q = em.createQuery("select d.elist from Dept d where d.dept_id = ?1" , Employee.class);
//		System.out.println("Enter Dept Id : ");
//		q.setParameter(1, sc.nextInt());
//		List<Employee> elist = q.getResultList();
//		if(!elist.isEmpty()) {
//			elist.forEach(System.out::println);
//		}
//		else {
//			System.err.println("No Record Found !!!");
//		}
//		try {}
//		finally {
//			sc.close();
//		}
//	}
//}
package org.jsp.onetomany;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FindEmpByDeptId {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("M15");
        EntityManager em = emf.createEntityManager();
        
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter Dept Id : ");
            int deptId = sc.nextInt();
            
            // Fetching the Department entity directly by its Primary Key
            Dept dept = em.find(Dept.class, deptId);
            
            if (dept != null) {
                List<Employee> elist = dept.getElist(); // Assumes your getter is getElist()
                
                if (elist != null && !elist.isEmpty()) {
                    elist.forEach(System.out::println);
                } else {
                    System.err.println("No Employees found in this Department !!!");
                }
            } else {
                System.err.println("No Department Found with ID: " + deptId);
            }

        } finally {
            // Clean up JPA resources to prevent connection leaks
            if (em != null && em.isOpen()) {
                em.close();
            }
            if (emf != null && emf.isOpen()) {
                emf.close();
            }
        }
    }
}