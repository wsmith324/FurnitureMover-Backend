package com.revature.furnituremover.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "home")
public class Home {
    @Id
    private String home_id;

    @Column(name = "name")
    private String name;

    @Column(name = "size")
    private int size;

    @OneToMany (
            mappedBy = "home",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<Furniture> furniture;

    public Home() {}

    public Home(String home_id, String name, int size) {
        this.home_id = home_id;
        this.name = name;
        this.size = size;
    }

    public String getHome_id() {
        return home_id;
    }

    public void setHome_id(String home_id) {
        this.home_id = home_id;
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
}
