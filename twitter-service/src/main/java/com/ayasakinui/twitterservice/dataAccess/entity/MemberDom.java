package com.ayasakinui.twitterservice.dataAccess.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "memberdoms")
public class MemberDom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long memberId;
    private Long domId;
    private Date createdAt;

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

    public Long getDomId() { return domId; }

    public Date getCreatedAt() { return createdAt; }

    public void setId(Long id) {
        this.id = id;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public void setDomId(Long domId) {
        this.domId = domId;
    }

    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    @Override
    public String toString() {
        return "MemberDom{" +
                "id=" + id +
                ", memberId=" + memberId +
                ", domId=" + domId +
                ", createdAt=" + createdAt +
                '}';
    }
}
