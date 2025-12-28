package com.example;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity // This annotation specifies that the class is an entity and is mapped to a database table.
public class Alien {
    
    @Id
    private int aid;
    private String aname;
    private String tech;
    // @OneToOne
    // private Laptop laptop;
    @OneToMany
    private List<Laptop> laptops;

    public List<Laptop> getLaptops() {
        return laptops;
    }   
    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    public int getAid() {
        return aid;
    }
    public void setAid(int aid) {
        this.aid = aid;
    }
    public String getAname() {
        return aname;
    }
    public void setAname(String aname) {
        this.aname = aname;
    }
    public String getTech() {
        return tech;
    }
    public void setTech(String tech) {
        this.tech = tech;
    }

    @Override
    public String toString() {
        return "Alien [aid=" + aid + ", aname=" + aname + ", tech=" + tech + ", laptops=" + laptops + "]";
    }
}
