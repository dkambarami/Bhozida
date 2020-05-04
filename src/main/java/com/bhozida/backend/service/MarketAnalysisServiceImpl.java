package com.bhozida.backend.service;

import com.bhozida.backend.model.BusinessCost;
import com.bhozida.backend.model.MarketAnalysis;
import com.bhozida.backend.repository.FactorOfProductionRepository;
import com.bhozida.backend.repository.MarketAnalysisRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketAnalysisServiceImpl implements MarketAnalysisService {

    private MarketAnalysisRepository marketAnalysisRepository;

    public MarketAnalysisServiceImpl(MarketAnalysisRepository marketAnalysisRepository) {
        this.marketAnalysisRepository = marketAnalysisRepository;
    }

    @Override
    public MarketAnalysis findById(Long aLong) {
        return marketAnalysisRepository.findById(aLong).get();
    }

    @Override
    public MarketAnalysis addUpdate(MarketAnalysis object) {
        return marketAnalysisRepository.save(object);
    }

    @Override
    public List<MarketAnalysis> findAll() {
        return marketAnalysisRepository.findAll();
    }

    @Override
    public void delete(MarketAnalysis object) {
 marketAnalysisRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        marketAnalysisRepository.deleteById(aLong);

    }

    @Override
    public boolean empty() {
        return marketAnalysisRepository.findAll().isEmpty();
    }

    @Override
    public List<MarketAnalysis> getSimilarType(Long id) {
        return null;
    }
}
