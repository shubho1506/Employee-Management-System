package beans;

import org.checkerframework.checker.units.qual.C;

import javax.persistence.*;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int projectID;
    @Column(nullable = false)
    private String projectName;

    @Column(nullable = false)
    private String projectLeader;

    public Project() {
    }

    public Project(String projectName,String projectLeader) {
        this.projectName = projectName;
        this.projectLeader = projectLeader;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectLeader() {
        return projectLeader;
    }

    public void setProjectLeader(String projectLeader) {
        this.projectLeader = projectLeader;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName +
                ", projectLeader='" + projectLeader +
                '}';
    }
}
