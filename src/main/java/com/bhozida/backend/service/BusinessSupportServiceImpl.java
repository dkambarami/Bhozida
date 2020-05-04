package com.bhozida.backend.service;

import com.bhozida.backend.model.BusinessSupport;
import com.bhozida.backend.repository.BusinessSupportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessSupportServiceImpl implements BusinessSupportService {

    private BusinessSupportRepository entreprenuerSupportRepository;

    public BusinessSupportServiceImpl(BusinessSupportRepository entreprenuerSupportRepository) {
        this.entreprenuerSupportRepository = entreprenuerSupportRepository;
    }


    @Override
    public BusinessSupport findById(Long aLong) {
        return entreprenuerSupportRepository.findById(aLong).get();
    }

    @Override
    public BusinessSupport addUpdate(BusinessSupport object) {
        return entreprenuerSupportRepository.save(object);
    }

    @Override
    public List<BusinessSupport> findAll() {
        return entreprenuerSupportRepository.findAll();
    }

    @Override
    public void delete(BusinessSupport object) {
    entreprenuerSupportRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
    entreprenuerSupportRepository.deleteById(aLong);
    }

    @Override
    public boolean empty() {
        return entreprenuerSupportRepository.findAll().isEmpty();
    }

    @Override
    public List<BusinessSupport> getSimilarType(Long id) {
        return null;
    }
}
