package beans;

import javax.persistence.*;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentID;

    @Column(nullable = false)
    private String departmentName;

    @Column(nullable = false)
    private String departmentHead;

    @Column(nullable = false)
    private String departmentLocation;


    public Department() {
    }

    public Department(String departmentName, String departmentHead, String departmentLocation) {
        this.departmentName = departmentName;
        this.departmentHead = departmentHead;
        this.departmentLocation = departmentLocation;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentHead() {
        return departmentHead;
    }

    public void setDepartmentHead(String departmentHead) {
        this.departmentHead = departmentHead;
    }

    public String getDepartmentLocation() {
        return departmentLocation;
    }

    public void setDepartmentLocation(String departmentLocation) {
        this.departmentLocation = departmentLocation;
    }


    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName +
                ", departmentHead='" + departmentHead +
                ", departmentLocation='" + departmentLocation +
                '}';
    }
}
