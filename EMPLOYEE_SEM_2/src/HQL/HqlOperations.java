package HQL;

import beans.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;
public class HqlOperations {
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

    public static void performClauseUsingHql() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("HQL Clause Operations Menu:");
            System.out.println("Press 1 to Retrieve Employees Ordered by Salary in ascending order ");
            System.out.println("Press 2 to Retrieve Employees Ordered by Salary descending order ");
            System.out.println("Press 3 to Exit");
            System.out.print("Please Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Employees ordered by salary in ascending order:");
                    retrieveEmployeesOrderedBySalaryAsc();
                    break;
                case 2:
                    System.out.println("Employees ordered by salary in descending order:");
                    retrieveEmployeesOrderedBySalaryDesc();
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            }
        }
        factory.close();
    }

    private static void retrieveEmployeesOrderedBySalaryAsc() {
        Session session = factory.openSession();
        try {
            session.beginTransaction();

            // Retrieve Employees ordered by salary in ascending order
//            FROM Employee ORDER BY salary ASC
            List<Employee> employees = session.createQuery("SELECT e FROM Employee e ORDER BY e.employeeSalary ASC").getResultList();
            for (Employee emp : employees) {
                System.out.println(emp);
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    private static void retrieveEmployeesOrderedBySalaryDesc() {
        Session session = factory.openSession();
        try {
            session.beginTransaction();

            // Retrieve Employees ordered by salary in descending order
            List<Employee> employees = session.createQuery("FROM Employee ORDER BY employeeSalary DESC").getResultList();
            for (Employee emp : employees) {
                System.out.println(emp);
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
