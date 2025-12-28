package com.example;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

@Entity
public class Laptop {
    @Id
    private int lid;
    private String brand;
    private String model;
    
    @ManyToMany(mappedBy = "laptops")
    private List<Alien> aliens;
    public List<Alien> getAliens() {
        return aliens;
    }
    public void setAliens(List<Alien> aliens) {
        this.aliens = aliens;
    }

    public int getLid() {
        return lid;
    }
    public void setLid(int lid) {
        this.lid = lid;
    }
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    @Override
    public String toString() {
        return "Laptop [lid=" + lid + ", brand=" + brand + ", model=" + model + "]";
    }
}
