package com.group.cars.Entities;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
@Table(name = "cars")
public class Car{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "Car_Id")
    private Long carID;
    
    @Column(name = "car_Model")
    private String carModel;
    
    @Column(name = "car_Brand")
    private String carBrand;
    
    private double price;
    
    @ManyToOne
    @JoinColumn(name = "family_group_group_id")
    private Family_Group familyGroup;

    public Car() {
    }

    public Car(Long carID,String carModel, String carBrand, double price,Family_Group fg) {
        this.carModel = carModel;
        this.carBrand = carBrand;
        this.price = price;
        this.setFamilyGroup(fg);
    }
    public Car(String carModel, String carBrand, double price,Family_Group fg) {
        this.carModel = carModel;
        this.carBrand = carBrand;
        this.price = price;
        this.setFamilyGroup(fg);
    }
    public Car(String carModel, String carBrand, double price) {
        this.carModel = carModel;
        this.carBrand = carBrand;
        this.price = price;
    }

    public Long getCarID() {
        return carID;
    }

    public void setCarID(Long carID) {
        this.carID = carID;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public double getPrice() {
        return price;
    }
    
    @Override
    public String toString() {
        return "Car [carID=" + carID + ", carModel=" + carModel + ", carBrand=" + carBrand + ", price=" + price
                + ", familyGroup=" + familyGroup + "]";
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public Family_Group getFamilyGroup() {
        return familyGroup;
    }

    public void setFamilyGroup(Family_Group familyGroup) {
        this.familyGroup = familyGroup;
    }
}
