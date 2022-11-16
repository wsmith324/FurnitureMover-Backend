package com.revature.furnituremover.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "furniture")
public class Furniture {
    @Id
    private String furniture_id;

    @Column(name = "name")
    private String name;

    @Column(name = "size")
    private int size;

    @ManyToOne
    @JoinColumn(name = "home_id", nullable = false)
    @JsonBackReference
    private Home home;

    public Furniture() {}

    public Furniture(String furniture_id, String name, int size, Home home) {
        this.furniture_id = furniture_id;
        this.name = name;
        this.size = size;
        this.home = home;
    }

    public String getId() {
        return furniture_id;
    }

    public void setId(String furniture_id) {
        this.furniture_id = furniture_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    @Override
    public String toString() {
        return "Furniture{" +
                "id='" + furniture_id + '\'' +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", home=" + home +
                '}';
    }
}
