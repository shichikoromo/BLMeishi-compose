package com.ayasakinui.twitterservice.dataAccess.repository;

import java.util.List;
import com.ayasakinui.twitterservice.dataAccess.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberdomRepository extends JpaRepository<Memberdoms, Long> {
    /*カスタムクエリ*/
    List<Memberdoms> findBydomId(int domId);
}
