package com.duckky.sb_ecom.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @NotBlank
    @Size(min = 3, message = "Product name must contain atleast 3 characters")
    private String productName;
    private String image;

    @NotBlank
    @Size(min = 6, message = "Product description must contain atleast 6 characters")
    private String description;

    @NotNull
    @Min(value = 0, message = "Quantity cannot be negative")
    private Integer quantity;

    @PositiveOrZero(message = "Price must be non-negative")
    private double price;

    @DecimalMin(value = "0.0", message = "Discount cannot be less than zero")
    @DecimalMax(value = "100.0", message = "Discount cannot exceed 100%")
    private double discount;
    private double specialPrice;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "seller_id")
    @JsonManagedReference
    private User user;
}
