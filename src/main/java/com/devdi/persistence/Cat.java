package com.devdi.persistence;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by devdi on 8/20/14.
 */
@Entity
public class Cat implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
