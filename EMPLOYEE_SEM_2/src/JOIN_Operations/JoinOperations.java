package JOIN_Operations;
import beans.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JoinOperations {
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

    public static void useJoinOperations() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Join Operations Main Menu:");
            System.out.println("Press 1 to perform Inner Join operation ");
            System.out.println("Press 2 to perform Left Outer Join operation ");
            System.out.println("Press 3 to perform Right Outer Join operation ");
            System.out.println("Press 4 to perform Full Outer Join operation ");
            System.out.println("Press 5 to perform Exit ");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    innerJoin();
                    break;
                case 2:
                    leftOuterJoin();
                    break;
                case 3:
                    rightOuterJoin();
                    break;
                case 4:
                    fullOuterJoin();
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

    private static void innerJoin() {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            String query = "SELECT e, r FROM Employee e INNER JOIN e.employeeResources r";
//            Query query = session.createQuery("SELECT e, r FROM Employee e INNER JOIN e.employeeResources r");
            Query query1 = session.createQuery(query);
            ArrayList<Object[]> results = (ArrayList<Object[]>) query1.getResultList();
            for (Object[] row : results) {
                Employee employee = (Employee) row[0];
                EmployeeResources ename = (EmployeeResources) row[1];
                System.out.println("Employee: " + employee + ", Resources: " + ename);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            handleException("Error performing inner join", e);
        }
    }

    private static void leftOuterJoin() {
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            Query query = session.createQuery("SELECT e, r FROM Employee e LEFT JOIN e.employeeResources r");
            List<Object[]> results = query.getResultList();
            for (Object[] row : results) {
                Employee employee = (Employee) row[0];
                EmployeeResources resources = (EmployeeResources) row[1];
                System.out.println("Employee: " + employee + ", Resources: " + resources);
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            handleException("Error performing left outer join", e);
        }
    }

    private static void rightOuterJoin() {
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            Query query = session.createQuery("SELECT e, r FROM Employee e RIGHT JOIN e.employeeResources r");
            List<Object[]> results = query.getResultList();
            for (Object[] row : results) {
                Employee employee = (Employee) row[0];
                EmployeeResources resources = (EmployeeResources) row[1];
                System.out.println("Employee: " + employee + ", Resources: " + resources);
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            handleException("Error performing right outer join", e);
        }
    }

    private static void fullOuterJoin() {
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            Query query = session.createQuery("SELECT e, r FROM Employee e FULL JOIN e.employeeResources r");
            List<Object[]> results = query.list();
            for (Object[] row : results) {
                Employee employee = (Employee) row[0];
                EmployeeResources resources = (EmployeeResources) row[1];
                System.out.println("Employee: " + employee + ", Resources: " + resources);
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            handleException("Error performing full outer join", e);
        }
    }

    private static void handleException(String message, Exception e) {
        System.err.println(message + ": " + e.getMessage());
        e.printStackTrace();
    }
}
