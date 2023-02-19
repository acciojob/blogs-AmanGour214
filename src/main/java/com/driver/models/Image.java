package com.driver.models;

import javax.persistence.*;

@Entity
@Table(name = "image_db")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    private String dimensions;
//image is child for blog
    @ManyToOne
    @JoinColumn
    private Blog blog;




    public Image() {
    }

    public Image(String description, String dimensions, Blog blog) {
        this.description = description;
        this.dimensions = dimensions;
        this.blog = blog;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimension() {
        return dimensions;
    }

    public void setDimension(String dimension) {
        this.dimensions = dimension;
    }
}
