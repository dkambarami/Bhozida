package com.bhozida.backend.service;

import com.bhozida.backend.model.BusinessCost;
import com.bhozida.backend.repository.BusinessCostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessCostServiceImpl implements BusinessCostService {

    private BusinessCostRepository businessCostRepository;

    public BusinessCostServiceImpl(BusinessCostRepository businessCostRepository) {
        this.businessCostRepository = businessCostRepository;
    }

    @Override
    public BusinessCost findById(Long aLong) {
        return businessCostRepository.findById(aLong).get();
    }

    @Override
    public BusinessCost addUpdate(BusinessCost object) {
        return businessCostRepository.save(object);
    }

    @Override
    public List<BusinessCost> findAll() {
        return businessCostRepository.findAll();
    }

    @Override
    public void delete(BusinessCost object) {
       businessCostRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        businessCostRepository.deleteById(aLong);

    }

    @Override
    public boolean empty() {
        return businessCostRepository.findAll().isEmpty();
    }

    @Override
    public List<BusinessCost> getSimilarType(Long id) {
        return null;
    }
}
