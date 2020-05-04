package com.bhozida.backend.repository;

import com.bhozida.backend.model.MarketAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MarketAnalysisRepository extends JpaRepository<MarketAnalysis, Long> {

}
