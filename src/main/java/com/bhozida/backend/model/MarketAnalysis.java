package com.bhozida.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;


@Component
@Entity
public class MarketAnalysis implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="businessIdea_id", referencedColumnName = "id")
    private BusinessIdea businessIdea;

    public MarketAnalysis() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BusinessIdea getBusinessIdea() {
        return businessIdea;
    }

    public void setBusinessIdea(BusinessIdea businessIdea) {
        this.businessIdea = businessIdea;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}