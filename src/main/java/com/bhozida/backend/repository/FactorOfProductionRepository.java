package com.bhozida.backend.repository;

import com.bhozida.backend.model.FactorOfProduction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface FactorOfProductionRepository extends JpaRepository<FactorOfProduction, Long> {

}
