package com.bhozida.backend.service;

import com.bhozida.backend.model.BusinessProcess;
import com.bhozida.backend.repository.BusinessProcessRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessProcessServiceImpl implements BusinessProcessService {

    private BusinessProcessRepository businessProcessRepository;

    public BusinessProcessServiceImpl(BusinessProcessRepository businessProcessRepository) {
            this.businessProcessRepository = businessProcessRepository;
    }

    @Override
    public BusinessProcess findById(Long aLong) {
        return businessProcessRepository.findById(aLong).get();
    }

    @Override
    public BusinessProcess addUpdate(BusinessProcess object) {
        return businessProcessRepository.save(object);
    }

    @Override
    public List<BusinessProcess> findAll() {
        return businessProcessRepository.findAll();
    }

    @Override
    public void delete(BusinessProcess object) {
        businessProcessRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        businessProcessRepository.deleteById(aLong);
    }

    @Override
    public boolean empty() {
        return businessProcessRepository.findAll().isEmpty();
    }

    @Override
    public List<BusinessProcess> getSimilarType(Long id) {
        return null;
    }
}
