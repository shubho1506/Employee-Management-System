package Main;

import JOIN_Operations.JoinOperations;
import Aggregate_Functions.AggregateFunctions;
import beans.*;
import CRUD_Operations.CrudOperations;
import CRUD_Operations.CrudOperations;
import HQL.HqlOperations;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final SessionFactory sf = new Configuration()
            .configure("resources/hibernate.cfg.xml")
            .addAnnotatedClass(Employee.class)
            .addAnnotatedClass(EmployeeAddress.class)
            .addAnnotatedClass(EmployeeResources.class)
            .addAnnotatedClass(EmployeeSalary.class)
            .addAnnotatedClass(EmployeeName.class)
            .addAnnotatedClass(Department.class)
            .addAnnotatedClass(Manager.class)
            .addAnnotatedClass(Project.class)
            .buildSessionFactory();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            while (true) {
                System.out.println("Employee - Main Menu");
                System.out.println("--------------------------------------------------------------------------");
                System.out.println("Press 1 to perform CRUD Operations using HQL");
                System.out.println("Press 2 to perform CRUD Library Functions");
                System.out.println("Press 3 to perform Aggregate Functions");
                System.out.println("Press 4 to perform Clauses using HQL");
                System.out.println("Press 5 to perform Native Queries");
                System.out.println("Press 6 to perform Perform Join Operations");
                System.out.println("Press 7 to perform Exit");
                System.out.println("--------------------------------------------------------------------------");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        crudOperationsUsingHql();
                        break;
                    case 2:
                        crudLibraryFunctions();
                        break;
                    case 3:
                        aggregateFunctions();
                        break;
                    case 4:
                        clauseUsingHql();
                        break;
                    case 5:
                        nativeQueries();
                        break;
                    case 6:
                        performJoinOperations();
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        shutdown();
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                }
            }
        } finally {
            sf.close(); // Close the session factory on program exit
        }
    }

    private static void crudOperationsUsingHql() {
        CrudOperations.performCRUDOperations();
    }

    private static void crudLibraryFunctions() {
        CrudOperations.performCRUDOperations();
    }

    private static void aggregateFunctions() {
        AggregateFunctions.useAggregate();
    }

    private static void clauseUsingHql() {
        HqlOperations.performClauseUsingHql();
    }

    private static void nativeQueries() {
        try {
            Session s = sf.openSession();
            Transaction transaction = s.beginTransaction();

            List<Object[]> results = s.createNativeQuery("SELECT * FROM Employee").getResultList();
            for (Object[] row : results) {
                for (Object obj : row) {
                    System.out.print(obj + "\t");
                }
                System.out.println();
            }

            s.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Error performing native queries: " + e.getMessage());
        }
    }
    private static void performJoinOperations() {
        JoinOperations.useJoinOperations();
    }

    private static void shutdown() {
        System.exit(0); // Terminate the program
    }
}

