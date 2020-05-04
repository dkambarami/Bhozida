package com.bhozida.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;


@Component
@Entity
public class BusinessProcess implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String description;
    @OneToOne(mappedBy = "businessProcess")
    private BusinessIdea businessIdea;


    public BusinessProcess() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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