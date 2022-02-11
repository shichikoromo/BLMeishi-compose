package com.ayasakinui.twitterservice.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "members")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String twitter_id;
    private String access_token;
    private String access_secret;
    private String icon;


    public Member() {
    }

    public Member(String name) {
        this.name = name;
    }

    public Member(String name, String twitter_id, String access_token, String oauth_verifier, String icon) {
        this.name = name;
        this.twitter_id = twitter_id;
        this.access_token = access_token;
        this.access_secret = oauth_verifier;
        this.icon = icon;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTwitter_id(){
        return twitter_id;
    }

    public String getAccess_token() {
        return access_token;
    }

    public String getAccess_secret() {
        return access_secret;
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

    public void setTwitter_id(String twitter_id) {
        this.twitter_id = twitter_id;
    }

    public void setAccess_token(String oauth_token) {
        this.access_token = oauth_token;
    }

    public void setAccess_secret(String oauth_verifier) {
        this.access_secret = oauth_verifier;
    }

    @Override
    public String toString() {
        return String.format("{id:%d,name:%s, twitter_id:%s, access_token:%s, access_secret:%s, icon:%s}"
        , id, name, twitter_id, access_token, access_token, icon);
    }
}
