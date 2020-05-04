package com.bhozida.backend.config.core_repository;

import com.bhozida.backend.config.core_model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
