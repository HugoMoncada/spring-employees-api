package com.hugomoncada.employees.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    @NotBlank(message = "firstName can't be blank")
    @NotNull(message = "firstName can't be null")
    @Length (min = 1, max = 20, message = "firstName must have between 1 and 20 characters")
    private String firstName; 

    @Column(name = "last_name")
    @NotBlank(message = "lastName can't be blank")
    @NotNull(message = "lastName can't be null")
    @Length (min = 1, max = 20, message = "lastName must have between 1 and 20 characters")
    private String lastName; 

    @Email(message = "Invalid email address")
    @NotBlank(message = "email can't be blank")
    @NotNull(message = "email can't be null")
    @Length (min = 1, max = 40, message = "email must have between 1 and 20 characters")
    private String email;

    public void setFirstName(String firstName) {
        this.firstName = firstName.trim();
    }

    public void setLastName(String lastName) {
        this.lastName = lastName.trim();
    }

    public void setEmail(String email) {
        this.email = email.trim();
    } 
    

    
}
