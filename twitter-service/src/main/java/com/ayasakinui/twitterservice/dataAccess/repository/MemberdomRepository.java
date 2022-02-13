package com.ayasakinui.twitterservice.dataAccess.repository;

import java.util.List;
import java.util.Optional;

import com.ayasakinui.twitterservice.dataAccess.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberdomRepository extends JpaRepository<MemberDom, Long> {
    /*カスタムクエリ*/
    List<MemberDom> findBydomId(Long domId);
}
