package beans;

import javax.persistence.*;

@Entity
public class EmployeeName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nameId;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String middleName;
    @Column(nullable = false)
    private String lastName;

    public EmployeeName() {
    }

    public EmployeeName( String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public int getNameId() {
        return nameId;
    }

    public void setNameId(int nameId) {
        this.nameId = nameId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String fullname(){
        return firstName+" "+middleName+" "+lastName;
    }

    @Override
    public String toString() {
        return "EmployeeName{" +
                "firstName='" + firstName +
                ", middleName='" + middleName +
                ", lastName='" + lastName +
                '}';
    }
}
