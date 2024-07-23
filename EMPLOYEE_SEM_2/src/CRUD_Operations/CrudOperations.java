package CRUD_Operations;

import beans.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;
public class CrudOperations {
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

    public static void performCRUDOperations(){
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("CRUD Operations Main Menu:");
            System.out.println("Press 1 to Add Employee to database");
            System.out.println("Press 2 to Read data of Employee from database");
            System.out.println("Press 3 to Update data of Employee in database");
            System.out.println("Press 4 to Delete Employee from database");
            System.out.println("Press 5 to Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createEmployee();
                    break;
                case 2:
                    readEmployee();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    deleteEmployee();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }
        // Don't forget to close the factory at the end
        factory.close();
    }

    private static void createEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Please enter employee details : ");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Please enter employee name details : ");
        System.out.println();
        System.out.print("Enter first name : ");
        String fname = scanner.nextLine();
        System.out.print("Enter middle name : ");
        String mname = scanner.nextLine();
        System.out.print("Enter last name : ");
        String lname = scanner.nextLine();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Please enter employee contact details : ");
        System.out.println();
        System.out.print("Enter Employee Phone no: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Employee email ID: ");
        String email = scanner.nextLine();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Please enter employee address details : ");
        System.out.println();
        System.out.print("Enter Employee house no: ");
        String hno = scanner.nextLine();
        System.out.print("Enter Employee street no: ");
        String sno = scanner.nextLine();
        System.out.print("Enter Employee city : ");
        String city = scanner.nextLine();
        System.out.print("Enter Employee state : ");
        String state = scanner.nextLine();
        System.out.print("Enter Employee pincode : ");
        int pCode = scanner.nextInt();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Please enter employee joining & salary details : ");
        System.out.println();
        System.out.print("Enter joining date (DD-MM-YYYY): ");
        String joiningDateStr = scanner.next();
        System.out.print("Enter Employee total salary: ");
        double tsalary = scanner.nextDouble();
        System.out.print("Enter Employee basic salary: ");
        double bsalary = scanner.nextDouble();
        System.out.print("Enter Employee DA salary: ");
        double dsalary = scanner.nextDouble();
        System.out.print("Enter Employee HRA salary: ");
        double hsalary = scanner.nextDouble();
        System.out.print("Enter Employee yearly bonus salary: ");
        double ysalary = scanner.nextDouble();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Please enter employee resource details : ");
        System.out.println();
        System.out.print("Enter resource name: ");
        String resourceName = scanner.nextLine();
        System.out.print("Enter resource Date of Issue: ");
        String resourceDate = scanner.nextLine();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Please enter employee department details : ");
        System.out.println();
        System.out.print("Enter department name: ");
        String dName = scanner.nextLine();
        System.out.print("Enter department current head: ");
        String dhead = scanner.nextLine();
        System.out.print("Enter department location: ");
        String dloc = scanner.nextLine();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Please enter employee project details : ");
        System.out.println();
        System.out.print("Enter employee project name: ");
        String pName = scanner.next();
        System.out.print("Enter employee project head: ");
        String pHead = scanner.next();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Please enter employee manager details : ");
        System.out.println();
        System.out.print("Enter employee manager name : ");
        String mName = scanner.next();


        try (Session session = factory.openSession()) {
            session.beginTransaction();

            //Create Name instance
            EmployeeName empName = new EmployeeName(fname,mname,lname);

            // Create Resources instance
            EmployeeResources empResources = new EmployeeResources(resourceName,resourceDate);

            //Create Address instance
            EmployeeAddress empAddr = new EmployeeAddress(hno,sno,city,state,pCode);

            //Create Salary instance
            EmployeeSalary empSalary = new EmployeeSalary(tsalary,bsalary,dsalary,hsalary,ysalary);

            //Create Manager instance
            Manager mng = new Manager(mName);

            //Create Department instance
            Department dept = new Department(dName,dhead,dloc);

            //Create Project instance
            Project pj = new Project(pName,pHead);

            // Create a new Employee
            Employee emp = new Employee(empName.fullname(),phone,email,joiningDateStr,empAddr.address(),empSalary.getTotalSalary(),empResources.getResourceName(),dName,pName,mName);
            emp.setEmpResources(empResources);
            session.save(empName);
            session.save(empAddr);
            session.save(empSalary);
            session.save(empResources);
            session.save(dept);
            session.save(mng);
            session.save(pj);
            session.save(emp);

            session.getTransaction().commit();
            System.out.println("Thank you for filling the details.");
            System.out.println("Employee has been added successfully.");
        } catch (Exception e) {
            handleException("Error creating employee", e);
        }
    }



    private static void readEmployee() {
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the employee ID: ");
            int id = scanner.nextInt();

            // Retrieve an Employee by ID
            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                // Display employee details
                System.out.println("-----Retrieved Employee Details: ------");
                System.out.println();
                System.out.println("ID: " + employee.getEmployeeID());
                System.out.println();
                System.out.println("Name: " + employee.getEmployeeName());
                System.out.println();
                System.out.println("Phone No: " + employee.getEmailID());
                System.out.println();
                System.out.println("Email ID: " + employee.getPhoneNumber());
                System.out.println();
                System.out.println("Address: " + employee.getEmployeeAddress());
                System.out.println();
                System.out.println("Salary: " + employee.getEmployeeSalary());
                System.out.println();
                System.out.println("Resources: " + employee.getEmployeeResources());
                System.out.println();
                System.out.println("Joining Date: " + employee.getDateOfJoining());
                System.out.println();
                System.out.println("Project: " + employee.getProjectDetails());
                System.out.println();
                System.out.println("Manager: " + employee.getManager());
                System.out.println();
                System.out.println("Department: " + employee.getEmployeeDepartment());
                System.out.println();
            } else {
                System.out.println("Employee with ID : " + id + " not found.");
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            handleException("Error reading employee", e);
        }
    }


    private static void updateEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            // Retrieve the Employee by ID
            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                // Display current employee details
                System.out.println("ID: " + employee.getEmployeeID());
                System.out.println();
                System.out.println("Name: " + employee.getEmployeeName());
                System.out.println();
                System.out.println("Phone No: " + employee.getEmailID());
                System.out.println();
                System.out.println("Email ID: " + employee.getPhoneNumber());
                System.out.println();
                System.out.println("Address: " + employee.getEmployeeAddress());
                System.out.println();
                System.out.println("Salary: " + employee.getEmployeeSalary());
                System.out.println();
                System.out.println("Resources: " + employee.getEmployeeResources());
                System.out.println();
                System.out.println("Joining Date: " + employee.getDateOfJoining());
                System.out.println();
                System.out.println("Project: " + employee.getProjectDetails());
                System.out.println();
                System.out.println("Manager: " + employee.getManager());
                System.out.println();
                System.out.println("Department: " + employee.getEmployeeDepartment());
                System.out.println();
                // Ask user which field to update
                System.out.print("Please Enter the field to update : ");
                String fieldToUpdate = scanner.nextLine().trim().toLowerCase();
                switch (fieldToUpdate) {
                    case "name":
                        System.out.println("Please enter new name details : ");
                        System.out.println();
                        System.out.print("Enter first name : ");
                        String fname = scanner.nextLine();
                        System.out.print("Enter middle name : ");
                        String mname = scanner.nextLine();
                        System.out.print("Enter last name : ");
                        String lname = scanner.nextLine();
                        EmployeeName empName = new EmployeeName();
                        empName.setFirstName(fname);
                        empName.setMiddleName(mname);
                        empName.setLastName(lname);
                        employee.setEmployeeName(empName.fullname());
                        break;
                    case "phone":
                        System.out.print("Enter new Phone no: ");
                        String phone = scanner.nextLine();
                        employee.setPhoneNumber(phone);
                        break;
                    case "email":
                        System.out.print("Enter Employee email ID: ");
                        String email = scanner.nextLine();
                        employee.setEmailID(email);
                        break;
                    case "address":
                        System.out.println("Please enter new address details : ");
                        System.out.println();
                        System.out.print("Enter Employee house no: ");
                        String hno = scanner.nextLine();
                        System.out.print("Enter Employee street no: ");
                        String sno = scanner.nextLine();
                        System.out.print("Enter Employee city : ");
                        String city = scanner.nextLine();
                        System.out.print("Enter Employee state : ");
                        String state = scanner.nextLine();
                        System.out.print("Enter Employee pincode : ");
                        int pCode = scanner.nextInt();
                        EmployeeAddress empAddr = new EmployeeAddress();
                        empAddr.setHouseNo(hno);
                        empAddr.setStreetNo(sno);
                        empAddr.setCity(city);
                        empAddr.setState(state);
                        empAddr.setPincode(pCode);
                        employee.setEmployeeAddress(empAddr.address());
                        break;
                    case "salary":
                        System.out.println("Please enter new salary details : ");
                        System.out.println();
                        System.out.print("Enter Employee total salary: ");
                        double tsalary = scanner.nextDouble();
                        System.out.print("Enter Employee basic salary: ");
                        double bsalary = scanner.nextDouble();
                        System.out.print("Enter Employee DA salary: ");
                        double dsalary = scanner.nextDouble();
                        System.out.print("Enter Employee HRA salary: ");
                        double hsalary = scanner.nextDouble();
                        System.out.print("Enter Employee yearly bonus salary: ");
                        double ysalary = scanner.nextDouble();
                        EmployeeSalary empSalary = new EmployeeSalary();
                        empSalary.setTotalSalary(tsalary);
                        empSalary.setBasicSalary(bsalary);
                        empSalary.setDearnessAllowance(dsalary);
                        empSalary.setHouseRentAllowance(hsalary);
                        empSalary.setYearlyBonus(ysalary);
                        employee.setEmployeeSalary(tsalary);
                        break;
                    case "resources":
                        System.out.println("Please enter new resource details : ");
                        System.out.println();
                        System.out.print("Enter resource name: ");
                        String resourceName = scanner.nextLine();
                        System.out.print("Enter resource Date of Issue: ");
                        String resourceDate = scanner.nextLine();
                        EmployeeResources empResources = new EmployeeResources();
                        empResources.setResourceName(resourceName);
                        empResources.setDateOfIssue(resourceDate);
                        employee.setEmployeeResources(resourceName);
                        break;
                    case "department":
                        System.out.println("Please enter new department details : ");
                        System.out.println();
                        System.out.print("Enter department name: ");
                        String dName = scanner.nextLine();
                        System.out.print("Enter department current head: ");
                        String dhead = scanner.nextLine();
                        System.out.print("Enter department location: ");
                        String dloc = scanner.nextLine();
                        Department dept = new Department();
                        dept.setDepartmentName(dName);
                        dept.setDepartmentHead(dhead);
                        dept.setDepartmentLocation(dloc);
                        employee.setEmployeeDepartment(dName);
                        break;
                    case "project":
                        System.out.println("Please enter new project details : ");
                        System.out.println();
                        System.out.print("Enter employee project name: ");
                        String pName = scanner.nextLine();
                        System.out.print("Enter employee project head: ");
                        String pHead = scanner.nextLine();
                        Project pj = new Project();
                        pj.setProjectName(pName);
                        pj.setProjectLeader(pHead);
                        employee.setProjectDetails(pName);
                        break;
                    case "manager":
                        System.out.println("Please enter new manager details : ");
                        System.out.println();
                        System.out.print("Enter employee manager name : ");
                        String mName = scanner.nextLine();
                        Manager mng = new Manager();
                        mng.setManagerName(mName);
                        employee.setManager(mName);
                        break;
                    default:
                        System.out.println("Invalid field. Please enter 'name' or 'salary'.");
                }
                session.update(employee);
                System.out.println("Employee with ID " + id + " updated successfully.");
            } else {
                System.out.println("Employee with ID " + id + " not found.");
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            handleException("Error updating employee", e);
        }
    }


    private static void deleteEmployee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the employee ID to delete: ");
        int id = scanner.nextInt();
        try (Session session = factory.openSession()) {
            session.beginTransaction();

            // Retrieve the Employee by ID
            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                // Delete the Employee
                session.delete(employee);
                System.out.println("Employee with ID " + id + " has been deleted successfully.");
            } else {
                System.out.println("!!!! Employee with ID " + id + " not found !!!!");
                System.out.println("!!!!!! Please try again with a valid employeeID !!!!!!!");
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            handleException("Error deleting Employee. Please try again after sometime !!!", e);
        }
    }

    private static void handleException(String message, Exception e) {
        System.err.println(message + ": " + e.getMessage());
        e.printStackTrace(); // Log the exception
        // Rollback transaction in case of error
        if (factory != null && factory.getCurrentSession() != null && factory.getCurrentSession().getTransaction() != null) {
            factory.getCurrentSession().getTransaction().rollback();
        }
    }
}
