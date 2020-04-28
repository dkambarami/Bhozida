package com.bhozida.backend.repository;

import com.bhozida.backend.model.Opportunity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OpportunityRepository extends CrudRepository<Opportunity, Long> {

    @Query("select o from Opportunity o where o.businessType like %?1")
    List<Opportunity> findByBusinessType(String businessType);
}
