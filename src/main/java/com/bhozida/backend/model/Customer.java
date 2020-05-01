package com.bhozida.backend.model;

import com.bhozida.backend.config.core_model.Role;
import com.bhozida.backend.config.core_model.User;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Collection;

@Data
@Component
@Entity
public class Customer extends User implements Serializable {
    public Customer() {
        super();
    }

    public Customer(String firstName, String lastName, String email, String password) {
        super(firstName, lastName, email, password);
    }

    public Customer(String firstName, String lastName, String email, String password, Collection<Role> roles) {
        super(firstName, lastName, email, password, roles);
    }

}
