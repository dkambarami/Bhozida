package com.bhozida.backend.service;

import com.bhozida.backend.model.MarketAnalysis;
import com.bhozida.backend.model.SubSector;
import com.bhozida.backend.repository.MarketAnalysisRepository;
import com.bhozida.backend.repository.SubSectorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubSectorServiceImpl implements SubSectorService {

    private SubSectorRepository subSectorRepository;

    public SubSectorServiceImpl(SubSectorRepository subSectorRepository) {
        this.subSectorRepository = subSectorRepository;
    }

    @Override
    public SubSector findById(Long aLong) {
        return subSectorRepository.findById(aLong).get();
    }

    @Override
    public SubSector addUpdate(SubSector object) {
        return subSectorRepository.save(object);
    }

    @Override
    public List<SubSector> findAll() {
        return subSectorRepository.findAll();
    }

    @Override
    public void delete(SubSector object) {
        subSectorRepository.delete(object);

    }

    @Override
    public void deleteById(Long aLong) {
        subSectorRepository.deleteById(aLong);

    }

    @Override
    public boolean empty() {
        return subSectorRepository.findAll().isEmpty();
    }

    @Override
    public List<SubSector> getSimilarType(Long id) {
        return null;
    }
}
