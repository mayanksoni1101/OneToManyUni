# One-to-Many Unidirectional Department & Employee Management System

A Java application demonstrating **One-to-Many Unidirectional** entity mapping using **JPA (Java Persistence API)** and **Hibernate ORM** within the `org.jsp.onetomany` package.

---

## 📌 Project Overview

This project models an organizational domain relationship where:
* **`Dept` (Parent / One-to-Many):** A Department contains a collection of Employees (`@OneToMany(cascade = CascadeType.ALL)`).
* **`Employee` (Child Entity):** An independent entity stored and managed within the context of a Department without maintaining a back-reference.

The repository includes complete entity mappings, data persistence utilities using cascade actions, and interactive console-driven query execution scripts using JPQL/HQL.

---

## 📂 Component Architecture & Structure

### 1. Entity Models

* **`Dept.java`**: Represents department records (`id`, `name`, `location`) holding a list of `Employee` objects (`elist`). Cascading actions (`CascadeType.ALL`) enable automatic child operations on persistence.
* **`Employee.java`**: Represents employee records (`id`, `name`, `salary`).

### 2. Data Insertion Utility

* **`InsertDetails.java`**: Seeds initial database records by creating departments (`HR`, `Accounts`) and linking employee batches before invoking `em.persist()`.

### 3. Lookup & Query Execution Utilities

#### 🏢 Department Operations
* **`FindDeptByIdFindMeth.java`**: Fetches department details by primary key using `em.find()`.
* **`FindDeptByName.java`**: Queries department details matching a department name.
* **`FindDeptByLoc.java`**: Queries department details matching a target location.

#### 👤 Employee Operations
* **`FindEmpByIdFindMeth.java`**: Fetches employee details by primary key using `em.find()`.
* **`FindEmpByName.java`**: Searches for employee records matching a given name.
* **`FindEmpBySal.java`**: Searches for employees matching a specific salary amount.
* **`FindEmpByDeptId.java`**: Retrieves all employees mapped under a specific Department ID.
* **`FindEmpByDeptAndLoc.java`**: Retrieves employees by querying parent department name and location.
* **`FindEmpByDeptIdAndName.java`**: Retrieves employees belonging to a department filtered by department ID and department name.

---

## 🛠️ Tech Stack & Mapping Specifications

* **Language:** Java
* **Persistence Standard:** JPA 2.0+ / Hibernate ORM
* **Annotations Used:** `@Entity`, `@Id`, `@GeneratedValue(strategy = GenerationType.IDENTITY)`, `@OneToMany(cascade = CascadeType.ALL)`
* **Data Access API:** `EntityManager`, `EntityTransaction`, `TypedQuery`, `Query` (JPQL)

---

## ⚙️ Setup & Running Instructions

1. **Database Setup:**
   Ensure your database connection details are correctly configured inside `src/META-INF/persistence.xml` under the persistence unit name `"M15"`.

2. **Data Initialization:**
   Execute `InsertDetails.java` as a Java Application to seed department and employee records.

3. **Query Execution:**
   Execute any `Find*.java` runner class to interactively query records via console input prompts.
