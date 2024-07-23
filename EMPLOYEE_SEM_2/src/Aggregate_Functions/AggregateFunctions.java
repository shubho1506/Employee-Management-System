package Aggregate_Functions;

import beans.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.Scanner;

public class AggregateFunctions {
    private static final SessionFactory factory = new Configuration()
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

    public static void useAggregate() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Aggregate Functions Main Menu:");
            System.out.println("Press 1 to Calculate Average Salary of Employees ");
            System.out.println("Press 2 to Calculate Total Salary of Employees ");
            System.out.println("Press 3 to Find Minimum Salary of Employees ");
            System.out.println("Press 4 to Find Maximum Salary of Employees ");
            System.out.println("Press 5 to Exit");
            System.out.print("Please Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    calculateAverageSalary();
                    break;
                case 2:
                    calculateTotalSalary();
                    break;
                case 3:
                    findMinimumSalary();
                    break;
                case 4:
                    findMaximumSalary();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
        factory.close();
    }

    private static void calculateAverageSalary() {
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            Query query = session.createQuery("SELECT AVG(employeeSalary) FROM Employee");
            double averageSalary = (double) query.getSingleResult();
            System.out.println("Average Salary: " + averageSalary);

            session.getTransaction().commit();
        } catch (Exception e) {
            handleException("Error calculating average salary", e);
        }
    }

    private static void calculateTotalSalary() {
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            Query query = session.createQuery("SELECT SUM(employeeSalary) FROM Employee");
            double totalSalary = (double) query.getSingleResult();
            System.out.println("Total Salary: " + totalSalary);

            session.getTransaction().commit();
        } catch (Exception e) {
            handleException("Error calculating total salary", e);
        }
    }

    private static void findMinimumSalary() {
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            Query query = session.createQuery("SELECT MIN(employeeSalary) FROM Employee");
            double minSalary = (double) query.getSingleResult();
            System.out.println("Minimum Salary: " + minSalary);

            session.getTransaction().commit();
        } catch (Exception e) {
            handleException("Error finding minimum salary", e);
        }
    }

    private static void findMaximumSalary() {
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            Query query = session.createQuery("SELECT MAX(employeeSalary) FROM Employee");
            double maxSalary = (double) query.getSingleResult();
            System.out.println("Maximum Salary: " + maxSalary);

            session.getTransaction().commit();
        } catch (Exception e) {
            handleException("Error finding maximum salary", e);
        }
    }

    private static void handleException(String message, Exception e) {
        System.err.println(message + ": " + e.getMessage());
        e.printStackTrace();
    }
}
