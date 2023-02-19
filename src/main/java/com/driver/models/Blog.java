package com.driver.models;


import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "blog_db")
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String content;
    @CreationTimestamp
    private Date pubDate;

    // blog is child for user  so i have to join the colum to user with there primary ky
    @ManyToOne
    @JoinColumn
    private User user;

    // Blogs is parent for Image because i can post Blog without Image so that why;
    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
    private List<Image>ImageList=new ArrayList<>();





    public Blog() {
    }

    public Blog(int id, String title, String content, Date pubDate, User user, List<Image> ImageList) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.pubDate = pubDate;
        this.user = user;
        this.ImageList = ImageList;
    }

    public List<Image> getImageList() {
        return ImageList;
    }

    public void setImageList(List<Image> imageList) {
        ImageList = imageList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }
}
