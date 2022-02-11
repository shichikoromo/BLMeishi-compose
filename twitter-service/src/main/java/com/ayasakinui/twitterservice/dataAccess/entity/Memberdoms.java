package com.ayasakinui.twitterservice.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "memberdoms")
public class Memberdoms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int memberId;
    private int domId;


    public Memberdoms() {
    }

    public Memberdoms(int id) {
        this.id = id;
    }

    public Memberdoms(int id, int memberId, int domId) {
        this.id = id;
        this.memberId = memberId;
        this.domId = domId;
    }

    public int getId() {
        return id;
    }

    public int getMemberId() {
        return memberId;
    }

    public int domId(){
        return domId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setDomId(int domId) {
        this.domId = domId;
    }

    @Override
    public String toString() {
        return String.format("{id:%d,id:%s, memberId:%s, domId:%s}"
        , id, id, memberId, domId);
    }
}
