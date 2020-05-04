package com.bhozida.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Component
@Entity

public class BusinessIdea implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Enumerated(EnumType.STRING)
    private BusinessSector sector;
    private BusinessSize size;
    private String name;
    private String description;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sub_sector_id", referencedColumnName = "id")
    private SubSector subSector;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "business_process_id", referencedColumnName = "id")
    private BusinessProcess businessProcess;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "business_cost_id", referencedColumnName = "id")
    private BusinessCost businessCost;
    @OneToMany(mappedBy = "businessIdea", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<MarketAnalysis> marketAnalysis =new HashSet<>();
    @OneToMany(mappedBy = "businessIdea", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<FactorOfProduction> factorOfProduction =new HashSet<>();
    @OneToMany(mappedBy = "businessIdea", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<BusinessSupport> businessSupport =new HashSet<>();

    public BusinessIdea() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BusinessSector getSector() {
        return sector;
    }

    public void setSector(BusinessSector sector) {
        this.sector = sector;
    }

    public BusinessSize getSize() {
        return size;
    }

    public void setSize(BusinessSize size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SubSector getSubSector() {
        return subSector;
    }

    public void setSubSector(SubSector subSector) {
        this.subSector = subSector;
    }

    public BusinessProcess getBusinessProcess() {
        return businessProcess;
    }

    public void setBusinessProcess(BusinessProcess businessProcess) {
        this.businessProcess = businessProcess;
    }

    public BusinessCost getBusinessCost() {
        return businessCost;
    }

    public void setBusinessCost(BusinessCost businessCost) {
        this.businessCost = businessCost;
    }

    public Set<MarketAnalysis> getMarketAnalysis() {
        return marketAnalysis;
    }

    public void setMarketAnalysis(Set<MarketAnalysis> marketAnalysis) {
        this.marketAnalysis = marketAnalysis;
    }

    public Set<FactorOfProduction> getFactorOfProduction() {
        return factorOfProduction;
    }

    public void setFactorOfProduction(Set<FactorOfProduction> factorOfProduction) {
        this.factorOfProduction = factorOfProduction;
    }

    public Set<BusinessSupport> getBusinessSupport() {
        return businessSupport;
    }

    public void setBusinessSupport(Set<BusinessSupport> businessSupport) {
        this.businessSupport = businessSupport;
    }
}