package com.bhozida.backend.repository;

import com.bhozida.backend.model.SubSector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SubSectorRepository extends JpaRepository<SubSector, Long> {

}
