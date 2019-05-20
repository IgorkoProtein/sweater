package com.example.sweater.domain;

import javax.persistence.*;

@Entity
public class Map {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String x;
    private String y;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public Map(String x, String y, String description, User user) {
    }

    public Map(String x, String y, User user, String description) {
        this.author = user;
        this.x = x;
        this.y = y;
        this.description = description;
    }

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
