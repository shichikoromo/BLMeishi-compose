package com.ayasakinui.twitterservice.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "memberdoms")
public class MemberDom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long memberId;
    private Long domId;


    public MemberDom() {
    }

    public MemberDom(Long id) {
        this.id = id;
    }

    public MemberDom(Long id, Long memberId, Long domId) {
        this.id = id;
        this.memberId = memberId;
        this.domId = domId;
    }

    public Long getId() {
        return id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public Long domId(){
        return domId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public void setDomId(Long domId) {
        this.domId = domId;
    }

    @Override
    public String toString() {
        return String.format("{id:%d,id:%s, memberId:%s, domId:%s}"
        , id, id, memberId, domId);
    }
}
