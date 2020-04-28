package com.bhozida.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Component
@Entity
public class Opportunity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String businessName;
    @Column(columnDefinition = "LONGTEXT")
    private String businessDescription;
    private String businessType;
    private String businessProduct;
    private String targetMarket;
    private String practicality;
    private float expectedSales;
    private float expectedProfit;
    private float expectedRateOfReturn;
    private float requiredCapital;
    private String requiredSkills;
}
