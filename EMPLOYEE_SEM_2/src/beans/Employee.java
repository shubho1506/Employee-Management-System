package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeID;
    @Column(nullable = false)
    private String employeeName;
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn
//    private EmployeeName empName;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false)
    private String emailID;
    @Column(nullable = false)
    private String dateOfJoining;
    @Column(nullable = false)
//    @JoinColumn
    private String employeeAddress;

//    @OneToOne(cascade = CascadeType.ALL)
//    private EmployeeAddress empAddress;
    @Column(nullable = false)
//    @JoinColumn
    private Double employeeSalary;

//    @OneToOne(cascade = CascadeType.ALL)
//    private EmployeeSalary empSalary;

    @Column(nullable = false)
    private String employeeResources;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private EmployeeResources empResources;

    public EmployeeResources getEmpResources() {
        return empResources;
    }

    public void setEmpResources(EmployeeResources empNResources) {
        this.empResources = empNResources;
    }

    @Column(nullable = false)
//    @JoinColumn
    private String employeeDepartment;

//    @ManyToOne(cascade = CascadeType.ALL)
//    private Department empDepartment;

    @Column(nullable = false)
//    @JoinColumn
    private String projectDetails;
//    @ManyToOne(cascade = CascadeType.ALL)
//    private Project empProject;

    @Column(nullable = false)
//    @JoinColumn
    private String manager;
//    @ManyToOne(cascade = CascadeType.ALL)
//    private Manager empManager;

    public Employee() {
    }

    public Employee(String employeeName, String phoneNumber, String emailID, String dateOfJoining,String employeeAddress, Double employeeSalary, String employeeResources, String employeeDepartment, String projectDetails,String manager) {
        this.employeeName = employeeName;
        this.phoneNumber = phoneNumber;
        this.emailID = emailID;
        this.dateOfJoining = dateOfJoining;
        this.employeeAddress = employeeAddress;
        this.employeeSalary = employeeSalary;
        this.employeeResources = employeeResources;
        this.employeeDepartment = employeeDepartment;
        this.projectDetails = projectDetails;
        this.manager = manager;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeeResources() {
        return employeeResources;
    }

    public void setEmployeeResources(String employeeResources) {
        this.employeeResources = employeeResources;
    }

    public String getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public String getProjectDetails() {
        return projectDetails;
    }

    public void setProjectDetails(String projectDetails) {
        this.projectDetails = projectDetails;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", Name=" + employeeName +
                ", phoneNumber=" + phoneNumber +
                ", emailID='" + emailID +
                ", dateOfJoining='" + dateOfJoining +
                ", Address=" + employeeAddress +
                ", Salary=" + employeeSalary+
                ", Resources Acquired =" + employeeResources +
                ", Department =" + employeeDepartment +
                ", project =" + projectDetails +
                ", manager =" + manager +
                '}';
    }
}
