package com.bhozida.backend.service;

import com.bhozida.backend.model.Customer;
import com.bhozida.backend.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer findById(Long aLong) {
        return customerRepository.findById(aLong).get();
    }

    @Override
    public Customer addUpdate(Customer entity) {
            if (entity.getId() == null) {
            entity = customerRepository.save(entity);
            return entity;
        } else {
            Optional<Customer> customer = customerRepository.findById(entity.getId());
            if (customer.isPresent()) {
                Customer newEntity = customer.get();
                newEntity.setEmail(entity.getEmail());
                newEntity.setPassword(entity.getPassword());
                newEntity = customerRepository.save(newEntity);

                return newEntity;
            } else {
                entity = customerRepository.save(entity);
                return entity;
            }
        }
    }

    @Override
    public List<Customer> findAll() {
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public void delete(Customer object) {
        customerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        customerRepository.deleteById(aLong);
    }

    @Override
    public boolean empty() {
        if (customerRepository.count() == 0)
            return true;
        else
            return false;
    }

    @Override
    public List<Customer> getSimilarType(Long id) {
        return null;
    }
}
