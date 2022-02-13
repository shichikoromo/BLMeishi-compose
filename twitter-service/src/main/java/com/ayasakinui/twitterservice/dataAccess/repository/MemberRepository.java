package com.ayasakinui.twitterservice.dataAccess.repository;

import com.ayasakinui.twitterservice.dataAccess.entity.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
}
