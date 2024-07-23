package test;

import beans.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class InsertData {
    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.configure("resources/hibernate.cfg.xml");
        config.addAnnotatedClass(Employee.class);
        config.addAnnotatedClass(EmployeeName.class);
        config.addAnnotatedClass(EmployeeSalary.class);
        config.addAnnotatedClass(EmployeeResources.class);
        config.addAnnotatedClass(EmployeeAddress.class);
        config.addAnnotatedClass(Department.class);
        config.addAnnotatedClass(Manager.class);
        config.addAnnotatedClass(Project.class);
        try (SessionFactory sf = config.buildSessionFactory()) {
            Session s = sf.openSession();
            Transaction transaction = s.beginTransaction();
            EmployeeName emp3Name = new EmployeeName("Sandeep", "Ashok", "Kumar");
            EmployeeAddress emp3Addr = new EmployeeAddress("WY-83","Street no - 08","Bangalore","Karnataka",530068);
            EmployeeSalary emp3Salary = new EmployeeSalary(70000, 45000, 8000, 11000, 6000);
            EmployeeResources emp3Resources = new EmployeeResources("Health Insurance", "22-02-2024");
            Manager mng3 = new Manager("Avinash Kumar");
            Project pj3 = new Project("Audit","Piyush Kumar");
            Department dept3 = new Department("Security", "Jasram Meena", "Banglore");
            Employee emp3 = new Employee(emp3Name.fullname(), "9827396437", "sandeep24@gmail.com", "11-01-2024",emp3Addr.address(), emp3Salary.getTotalSalary(), emp3Resources.getResourceName(), dept3.getDepartmentName(), pj3.getProjectName(), mng3.getManagerName());
            s.save(emp3Name);
            s.save(emp3Addr);
            s.save(emp3Salary);
            s.save(emp3Resources);
            s.save(dept3);
            s.save(mng3);
            s.save(pj3);
            s.save(emp3);
            transaction.commit();
            s.evict(emp3);
            s.evict(emp3Name);
            s.evict(emp3Addr);
            s.evict(emp3Salary);
            s.evict(emp3Resources);
            s.evict(dept3);
            s.evict(mng3);
            s.evict(pj3);
            s.close();
            sf.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
