package com.bhozida.backend.service;

import com.bhozida.backend.model.Opportunity;
import com.bhozida.backend.repository.OpportunityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OpportunityServiceImpl implements OpportunityService {

    private OpportunityRepository opportunityRepository;

    public OpportunityServiceImpl(OpportunityRepository opportunityRepository) {
        this.opportunityRepository = opportunityRepository;
    }

    @Override
    public Opportunity findById(Long aLong) {
        return opportunityRepository.findById(aLong).get();
    }

    @Override
    public Opportunity addUpdate(Opportunity entity) {
        if (entity.getId() == null) {
            entity = opportunityRepository.save(entity);
            return entity;
        } else {
            Optional<Opportunity> opportunity = opportunityRepository.findById(entity.getId());
            if (opportunity.isPresent()) {
                Opportunity newEntity = opportunity.get();
                newEntity.setBusinessName(entity.getBusinessName());
                newEntity.setBusinessDescription(entity.getBusinessDescription());
                newEntity.setBusinessType(entity.getBusinessType());
                newEntity.setBusinessProduct(entity.getBusinessProduct());
                newEntity.setTargetMarket(entity.getTargetMarket());
                newEntity.setPracticality(entity.getPracticality());
                newEntity.setRequiredSkills(entity.getRequiredSkills());
                newEntity.setExpectedSales(entity.getExpectedSales());
                newEntity.setExpectedProfit(entity.getExpectedProfit());
                newEntity.setExpectedRateOfReturn(entity.getExpectedRateOfReturn());
                newEntity.setRequiredCapital(entity.getRequiredCapital());
                newEntity = opportunityRepository.save(newEntity);
                return newEntity;
            } else {
                entity = opportunityRepository.save(entity);
                return entity;
            }
        }
    }

    @Override
    public List<Opportunity> findAll() {
        return (List<Opportunity>) opportunityRepository.findAll();
    }

    @Override
    public void delete(Opportunity object) {
        opportunityRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        opportunityRepository.deleteById(aLong);
    }

    @Override
    public boolean empty() {
        if (opportunityRepository.count() == 0)
            return true;
        else
            return false;
    }

    public List<Opportunity> getSimilarType(Long id) {
        Opportunity currentOpportunity = opportunityRepository.findById(id).get();
        String currentBusinessType = currentOpportunity.getBusinessType();
        return opportunityRepository.findByBusinessType(currentBusinessType);
    }
}
