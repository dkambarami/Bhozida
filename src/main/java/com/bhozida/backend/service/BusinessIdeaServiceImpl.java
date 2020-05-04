package com.bhozida.backend.service;

import com.bhozida.backend.model.BusinessIdea;
import com.bhozida.backend.repository.BusinessIdeaRepository;
import com.bhozida.backend.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BusinessIdeaServiceImpl implements BusinessIdeaService {

    private BusinessIdeaRepository businessIdeaRepository;

    public BusinessIdeaServiceImpl(BusinessIdeaRepository businessIdeaRepository) {
        this.businessIdeaRepository = businessIdeaRepository;
    }

    @Override
    public BusinessIdea findById(Long aLong) {
        return businessIdeaRepository.findById(aLong).get();
    }

    @Override
    public BusinessIdea addUpdate(BusinessIdea object) {
        return businessIdeaRepository.save(object);
    }

    @Override
    public List<BusinessIdea> findAll() {
        return businessIdeaRepository.findAll();
    }

    @Override
    public void delete(BusinessIdea object) {
        businessIdeaRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        businessIdeaRepository.deleteById(aLong);
    }

    @Override
    public boolean empty() {
        return businessIdeaRepository.findAll().isEmpty();
    }

    @Override
    public List<BusinessIdea> getSimilarType(Long id) {
        return null;
    }
}
