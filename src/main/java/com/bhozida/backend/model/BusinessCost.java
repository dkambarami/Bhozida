package com.bhozida.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Component
@Entity
public class BusinessCost implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Enumerated(EnumType.STRING)
    private BusinessCostType type;
    private String item;
    private String unit;
    private Double unitCost;
    private Double quantity;
    @OneToOne(mappedBy = "businessCost")
    private BusinessIdea businessIdea;

    public BusinessCost() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BusinessCostType getType() {
        return type;
    }

    public void setType(BusinessCostType type) {
        this.type = type;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(Double unitCost) {
        this.unitCost = unitCost;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public BusinessIdea getBusinessIdea() {
        return businessIdea;
    }

    public void setBusinessIdea(BusinessIdea businessIdea) {
        this.businessIdea = businessIdea;
    }
}