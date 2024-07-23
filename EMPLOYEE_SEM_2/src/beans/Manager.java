package beans;

import org.checkerframework.checker.units.qual.C;

import javax.persistence.*;

@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int managerID;

    @Column(nullable = false)
    private String managerName;

    public Manager() {
    }

    public Manager(String managerName) {
        this.managerName = managerName;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "managerName='" + managerName +
                '}';
    }
}
