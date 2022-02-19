package com.ayasakinui.twitterservice.dataAccess.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "doms")
public class Dom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String manager;
    private String icon;
    private Date created_at;


    public Dom() {
    }

    public Dom(String name) {
        this.name = name;
    }

    public Dom(String name, String description, String manager, String icon, Date created_at) {
        this.name = name;
        this.description = description;
        this.manager = manager;
        this.icon = icon;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Dom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", manager='" + manager + '\'' +
                ", icon='" + icon + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}
