package com.main.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Film")
public class Film implements Serializable {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "Id")
    private Integer Id;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Images")
    private String Images;

    @Column(name = "Actor")
    private String Actor;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImages() {
        return Images;
    }

    public void setImages(String images) {
        Images = images;
    }

    public String getActor() {
        return Actor;
    }

    public void setActor(String actor) {
        Actor = actor;
    }
}
