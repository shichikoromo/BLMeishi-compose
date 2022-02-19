package com.ayasakinui.twitterservice.dataAccess.repository;

import com.ayasakinui.twitterservice.dataAccess.entity.Dom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomRepository extends CrudRepository<Dom, Long>{
}


