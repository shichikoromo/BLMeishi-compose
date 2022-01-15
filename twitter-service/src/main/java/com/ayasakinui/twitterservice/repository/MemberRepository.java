package com.ayasakinui.twitterservice.repository;

import com.ayasakinui.twitterservice.entity.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
}
