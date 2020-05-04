package com.bhozida.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Component
@Entity
public class FactorOfProduction implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String name;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="businessIdea_id", referencedColumnName = "id")
    private BusinessIdea businessIdea;

    public FactorOfProduction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public BusinessIdea getBusinessIdea() {
        return businessIdea;
    }

    public void setBusinessIdea(BusinessIdea businessIdea) {
        this.businessIdea = businessIdea;
    }
}