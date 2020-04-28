package com.bhozida.backend.config.core_repository;

import com.bhozida.backend.config.constraint.FieldMatch;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.AssertTrue;

@Data
@NoArgsConstructor
@FieldMatch.List({
        @FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match"),
        @FieldMatch(first = "email", second = "confirmEmail", message = "The email fields must match")
})
public class UserRegistrationDto {
    private String firstName;
    private String lastName;
    private String password;
    private String confirmPassword;
    private String email;
    private String confirmEmail;
    @AssertTrue
    private Boolean terms;

}