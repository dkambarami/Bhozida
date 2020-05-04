package com.bhozida.backend.service;

import com.bhozida.backend.model.BusinessCost;
import com.bhozida.backend.model.FactorOfProduction;
import com.bhozida.backend.repository.BusinessCostRepository;
import com.bhozida.backend.repository.FactorOfProductionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactorOfProductionServiceImpl implements FactorOfProductionService {

    private FactorOfProductionRepository factorOfProductionRepository;

    public FactorOfProductionServiceImpl(FactorOfProductionRepository factorOfProductionRepository) {
        this.factorOfProductionRepository = factorOfProductionRepository;
    }

    @Override
    public FactorOfProduction findById(Long aLong) {
        return factorOfProductionRepository.findById(aLong).get();
    }

    @Override
    public FactorOfProduction addUpdate(FactorOfProduction object) {
        return factorOfProductionRepository.save(object);
    }

    @Override
    public List<FactorOfProduction> findAll() {
        return factorOfProductionRepository.findAll();
    }

    @Override
    public void delete(FactorOfProduction object) {
        factorOfProductionRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        factorOfProductionRepository.deleteById(aLong);

    }

    @Override
    public boolean empty() {
        return factorOfProductionRepository.findAll().isEmpty();
    }

    @Override
    public List<FactorOfProduction> getSimilarType(Long id) {
        return null;
    }
}
