package com.bhozida.backend.controller;

import com.bhozida.backend.model.*;
import com.bhozida.backend.service.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@Service
public class BusinessIdeaDTO {

    @Autowired
    private BusinessIdeaService businessIdeaService;
    @Autowired
    private BusinessCostService businessCostService;
    @Autowired
    private BusinessProcessService businessProcessService;
    @Autowired
    private BusinessSupportService businessSupportService;
    @Autowired
    private FactorOfProductionService factorOfProductionService;
    @Autowired
    private MarketAnalysisService marketAnalysisService;
    @Autowired
    private SubSectorService subSectorService;

    private BusinessSector businessIdeaSector;
    private BusinessSize businessSize;
    private String businessIdeaName;
    private String businessIdeaDescription;
    private String businessProcessDescription;
    private BusinessCostType businessCostType;
    private String businessCostItem;
    private String businessCostUnit;
    private Double businessCostUnitCost;
    private Double businessCostQuantity;
    private String marketAnalysisDescription;
    private String factorOfProductionName;
    private String factorOfProductionDescription;
    private BusinessSupportType businessSupportType ;
    private String businessSupportDescription;
    private String subSectorName;
    private String subSectorDescription;

    public BusinessIdea makeBusinessIdea(){
        // Get Business Description Idea Details from DTO
        BusinessIdea businessIdea = new BusinessIdea();
        businessIdea.setName(this.businessIdeaName);
        businessIdea.setDescription(this.businessIdeaDescription);
        businessIdea.setSize(this.businessSize);
        businessIdea=businessIdeaService.addUpdate(businessIdea);

        // Get Business Costs --- Looping is required here.
        BusinessCost businessCost = new BusinessCost();
        businessCost.setBusinessIdea(businessIdea);
        businessCost.setItem(this.businessCostItem);
        businessCost.setType(this.businessCostType);
        businessCost.setUnit(this.businessCostUnit);
        businessCost.setUnitCost(this.businessCostUnitCost);
        businessCost.setQuantity(this.businessCostQuantity);

        //These three are essential to save the object
        businessCost=businessCostService.addUpdate(businessCost);
        businessIdea.setBusinessCost(businessCost);
        businessIdea=businessIdeaService.addUpdate(businessIdea);

        // Get Business Process--- No Looping Required
        BusinessProcess businessProcess = new BusinessProcess();
        businessProcess.setBusinessIdea(businessIdea);
        businessProcess.setDescription(this.businessProcessDescription);
        businessProcess=businessProcessService.addUpdate(businessProcess);
        businessIdea.setBusinessProcess(businessProcess);
        businessIdea=businessIdeaService.addUpdate(businessIdea);

        // Get Business Sector--- Looping Required to get all related supports
        Set<BusinessSupport> businessSupportSet = new HashSet<BusinessSupport>();
        BusinessSupport businessSupport = new BusinessSupport();
        businessSupport.setBusinessIdea(businessIdea);
        // TODO Check business support type enum
        businessSupport.setType(this.businessSupportType);
        businessSupport.setDescription(this.getBusinessProcessDescription());
        businessSupport=businessSupportService.addUpdate(businessSupport);
        businessSupportSet.add(businessSupport);
        businessIdea.setBusinessSupport(businessSupportSet);
        businessIdea=businessIdeaService.addUpdate(businessIdea);

        //Factors of production Set
        Set<FactorOfProduction> factorOfProductionSet = new HashSet<FactorOfProduction>();
        FactorOfProduction factorOfProduction = new FactorOfProduction();
        FactorOfProduction factorOfProduction2 = new FactorOfProduction();
        FactorOfProduction factorOfProduction3 = new FactorOfProduction();


        factorOfProduction.setBusinessIdea(businessIdea);
        factorOfProduction.setDescription(this.getFactorOfProductionDescription());
        factorOfProduction2.setBusinessIdea(businessIdea);
        factorOfProduction2.setDescription(this.getFactorOfProductionDescription());
        factorOfProduction3.setBusinessIdea(businessIdea);
        factorOfProduction3.setDescription(this.getFactorOfProductionDescription());

        factorOfProduction=factorOfProductionService.addUpdate(factorOfProduction);
        factorOfProduction2=factorOfProductionService.addUpdate(factorOfProduction2);
        factorOfProduction3=factorOfProductionService.addUpdate(factorOfProduction3);

        factorOfProductionSet.add(factorOfProduction);
        factorOfProductionSet.add(factorOfProduction2);
        factorOfProductionSet.add(factorOfProduction3);

        businessIdea.setFactorOfProduction(factorOfProductionSet);
        businessIdea=businessIdeaService.addUpdate(businessIdea);


        //Market Analysis - Single Market Analysis
        // TODO check market analysis set or just one.
        Set<MarketAnalysis> marketAnalysisSet = new HashSet<MarketAnalysis>();
        MarketAnalysis marketAnalysis = new MarketAnalysis();
        marketAnalysis.setBusinessIdea(businessIdea);
        marketAnalysis.setDescription(this.getMarketAnalysisDescription());
        marketAnalysis=marketAnalysisService.addUpdate(marketAnalysis);
        marketAnalysisSet.add(marketAnalysis);
        businessIdea.setMarketAnalysis(marketAnalysisSet);
        businessIdea=businessIdeaService.addUpdate(businessIdea);

        //Market Analysis - Single Market Analysis
        // TODO check subsector definitions
        SubSector subSector = new SubSector();
        subSector.setBusinessIdea(businessIdea);
        subSector.setName(this.getSubSectorName());
        subSector.setDescription(this.getSubSectorDescription());
        subSector=subSectorService.addUpdate(subSector);
        businessIdea.setSubSector(subSector);
        businessIdea=businessIdeaService.addUpdate(businessIdea);
        return businessIdea;
    }
}
