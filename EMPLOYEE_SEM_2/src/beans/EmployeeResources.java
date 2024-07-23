package beans;

import javax.persistence.*;

@Entity
public class EmployeeResources {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resourceID;

    @Column(nullable = false)
    private String resourceName;

    @Column(nullable = false)
    private String dateOfIssue;

    public EmployeeResources() {
    }

    public EmployeeResources(String resourceName, String dateOfIssue) {
        this.resourceName = resourceName;
        this.dateOfIssue = dateOfIssue;
    }

    public int getResourceID() {
        return resourceID;
    }

    public void setResourceID(int resourceID) {
        this.resourceID = resourceID;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(String dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    @Override
    public String toString() {
        return "EmployeeResources{" +
                "resourceName='" + resourceName +
                ", dateOfIssue='" + dateOfIssue +
                '}';
    }
}
