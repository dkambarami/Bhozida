package com.bhozida.backend.model;

import com.bhozida.backend.config.core_model.Role;
import com.bhozida.backend.config.core_model.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Collection;

@Data
@Component
@Entity
@NoArgsConstructor
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String firstName;
    String lastName;
    String email;
    String password;

}
