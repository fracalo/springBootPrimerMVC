package com.example.demothymeleaf;

import javax.persistence.*;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    public Integer id;

    @Column
    public String title;
    @Column
    public String description;

    @Column
    public String created_at;

    @Column
    public String updated_at;


    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCreated_at(String s) {
        this.created_at = s;
    }

    public void setUpdated_at(String s) {
        this.updated_at = s;
    }

    // used to prepare the link in templates
    public String getLink() {
        return this.id == null ? "/todo" : "/todo?id=" + this.id.toString();
    }

    public String getDeleteLink() {
        return "/todo/delete?id=" + this.id.toString();
    }
}
