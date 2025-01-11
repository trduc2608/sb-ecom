package com.duckky.sb_ecom.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    @NotBlank
    @Size(min = 5, message = "Street name must contain at least 5 characters")
    private String street;

    @NotBlank
    @Size(min = 5, message = "Building name must contain at least 5 characters")
    private String buildingName;

    @NotBlank
    @Size(min = 4, message = "City name must contain at least 4 characters")
    private String city;

    @NotBlank
    @Size(min = 2, message = "State name must contain at least 2 characters")
    private String state;

    @NotBlank
    @Size(min = 2, message = "Country name must contain at least 2 characters")
    private String country;

    @NotBlank
    @Size(min = 6, message = "Zip code must contain at least 6 characters")
    private String zipCode;

    @ToString.Exclude
    @ManyToMany(mappedBy = "addresses")
    private List<User> users = new ArrayList<>();

    public Address(String street, String buildingName, String city, String state, String country, String zipCode) {
        this.street = street;
        this.buildingName = buildingName;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }
}
