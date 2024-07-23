package beans;

import javax.persistence.*;

@Entity
public class EmployeeAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String addressID;

    @Column(nullable = false)
    private String houseNo;
    @Column(nullable = false)
    private String streetNo;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private int pincode;

    public EmployeeAddress() {
    }

    public EmployeeAddress(String houseNo, String streetNo, String city, String state,int pincode) {
        this.houseNo = houseNo;
        this.streetNo = streetNo;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public String getAddressID() {
        return addressID;
    }

    public void setAddressID(String addressID) {
        this.addressID = addressID;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String address(){
        return houseNo+" "+streetNo+" "+city+" "+state+" "+pincode;
    }

    @Override
    public String toString() {
        return "EmployeeAddress{" +
                "addressID='" + addressID +
                ", houseNo='" + houseNo +
                ", streetNo='" + streetNo +
                ", city='" + city +
                ", state='" + state +
                ", pincode=" + pincode +
                '}';
    }
}
