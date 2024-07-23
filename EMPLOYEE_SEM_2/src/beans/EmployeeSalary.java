package beans;

import javax.persistence.*;

@Entity
public class EmployeeSalary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int salaryID;

    @Column(nullable = false)
    private double totalSalary;

    @Column(nullable = false)
    private double basicSalary;

    @Column(nullable = false)
    private double dearnessAllowance;

    @Column(nullable = false)
    private double houseRentAllowance;

    @Column(nullable = false)
    private double yearlyBonus;

    public EmployeeSalary() {
    }

    public EmployeeSalary(double totalSalary,double basicSalary, double dearnessAllowance, double houseRentAllowance, double yearlyBonus) {
        this.totalSalary = totalSalary;
        this.basicSalary = basicSalary;
        this.dearnessAllowance = dearnessAllowance;
        this.houseRentAllowance = houseRentAllowance;
        this.yearlyBonus = yearlyBonus;
    }

    public int getSalaryID() {
        return salaryID;
    }

    public void setSalaryID(int salaryID) {
        this.salaryID = salaryID;
    }

    public double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getDearnessAllowance() {
        return dearnessAllowance;
    }

    public void setDearnessAllowance(double dearnessAllowance) {
        this.dearnessAllowance = dearnessAllowance;
    }

    public double getHouseRentAllowance() {
        return houseRentAllowance;
    }

    public void setHouseRentAllowance(double houseRentAllowance) {
        this.houseRentAllowance = houseRentAllowance;
    }

    public double getYearlyBonus() {
        return yearlyBonus;
    }

    public void setYearlyBonus(double yearlyBonus) {
        this.yearlyBonus = yearlyBonus;
    }


    @Override
    public String toString() {
        return "EmployeeSalary{" +
                "totalSalary = " + totalSalary +
                "basicSalary =" + basicSalary +
                ", dearnessAllowance =" + dearnessAllowance +
                ", houseRentAllowance =" + houseRentAllowance +
                ", yearlyBonus =" + yearlyBonus +
                '}';
    }
}
