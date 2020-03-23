package com.main.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Song")
public class Song implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "Id")
    private Integer Id;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Images")
    private String Images;

    @Column(name = "Singer")
    private String Singer;

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

    public String getSinger() {
        return Singer;
    }

    public void setSinger(String singer) {
        Singer = singer;
    }
}
