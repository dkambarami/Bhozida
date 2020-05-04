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
public class BusinessSupport implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Enumerated(EnumType.STRING)
    private BusinessSupportType type;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="businessIdea_id", referencedColumnName = "id")
    private BusinessIdea businessIdea;

    public BusinessSupport() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BusinessSupportType getType() {
        return type;
    }

    public void setType(BusinessSupportType type) {
        this.type = type;
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
