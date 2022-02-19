package com.ayasakinui.twitterservice.dataAccess.repository;

import com.ayasakinui.twitterservice.dataAccess.entity.MemberDom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberDomRepository extends JpaRepository<MemberDom, Long> {
    /*カスタムクエリ*/
    List<MemberDom> findBydomId(Long domId);
}
