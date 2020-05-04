package com.bhozida.backend;

import com.bhozida.backend.controller.BusinessIdeaDTO;
import com.bhozida.backend.model.BusinessCostType;
import com.bhozida.backend.model.BusinessSector;
import com.bhozida.backend.model.BusinessSize;
import com.bhozida.backend.model.BusinessSupportType;
import com.sun.media.jfxmedia.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BhozidaApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(BhozidaApplication.class, args);
        BusinessIdeaDTO businessIdeaDTO= ctx.getBean(BusinessIdeaDTO.class);
        businessIdeaDTO.setBusinessIdeaSector(BusinessSector.AGRICULTURE);
        businessIdeaDTO.setBusinessSize(BusinessSize.LARGE);
        businessIdeaDTO.setBusinessIdeaName("TESTING");
        businessIdeaDTO.setBusinessIdeaDescription("TESTING");
        businessIdeaDTO.setBusinessProcessDescription("TESTING");
        businessIdeaDTO.setBusinessCostType(BusinessCostType.CAPITAL);
        businessIdeaDTO.setBusinessCostItem("Sugar");
        businessIdeaDTO.setBusinessCostUnit("KG");
        businessIdeaDTO.setBusinessCostUnitCost(100.00);
        businessIdeaDTO.setBusinessCostQuantity(10.00);
        businessIdeaDTO.setMarketAnalysisDescription("Easy Market");
        businessIdeaDTO.setFactorOfProductionName("Capital easily Assessible");
        businessIdeaDTO.setFactorOfProductionDescription("Difficult");
        businessIdeaDTO.setBusinessSupportType(BusinessSupportType.GOVERNMENT);
        businessIdeaDTO.setBusinessSupportDescription("COMMAND AGRICULTURE");
        businessIdeaDTO.setSubSectorName("AGRICULTURE -FREE");
        businessIdeaDTO.setSubSectorDescription("NEW FARMER");
        businessIdeaDTO.makeBusinessIdea();
    }

}
