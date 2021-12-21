package com.ayasakinui.twitterservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String oauth_token;
    private String oauth_verifier;


    protected User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, String oauth_token, String oauth_verifier) {
        this.name = name;
        this.oauth_token = oauth_token;
        this.oauth_verifier = oauth_verifier;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOauth_token() {
        return oauth_token;
    }

    public String getOauth_verifier() {
        return oauth_verifier;
    }

    @Override
    public String toString() {
        return String.format("{id:%d,name:%s}", id, name);
    }
}
