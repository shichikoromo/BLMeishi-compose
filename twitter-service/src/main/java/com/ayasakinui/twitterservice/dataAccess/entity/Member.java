package com.ayasakinui.twitterservice.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String twitterId;
    private String accessToken;
    private String accessSecret;
    private String icon;


    public Member() {
    }

    public Member(String name) {
        this.name = name;
    }

    public Member(String name, String twitterId, String accessToken, String accessSecret, String icon) {
        this.name = name;
        this.twitterId = twitterId;
        this.accessToken = accessToken;
        this.accessSecret = accessSecret;
        this.icon = icon;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTwitterId(){
        return twitterId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getAccessSecret() {
        return accessSecret;
    }

    public String getIcon(){
        return icon;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTwitterId(String twitter_id) {
        this.twitterId = twitter_id;
    }

    public void setAccessToken(String oauth_token) {
        this.accessToken = oauth_token;
    }

    public void setAccessSecret(String oauth_verifier) {
        this.accessSecret = oauth_verifier;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", twitterId='" + twitterId + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", accessSecret='" + accessSecret + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
