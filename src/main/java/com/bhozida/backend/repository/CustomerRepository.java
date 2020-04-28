package com.bhozida.backend.repository;

import com.bhozida.backend.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
