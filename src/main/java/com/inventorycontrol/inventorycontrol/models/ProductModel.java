package com.inventorycontrol.inventorycontrol.models;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "TB_products")
public class ProductModel implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = false)
    @NotBlank
    private String name;
    @Column(nullable = false, unique = false)
    @NotBlank
    private String brand;
    @Column(nullable = false, unique = false)
    private String price;
    @Column(nullable = false, unique = false)
    private String quantityInStock;
    @Column(nullable = false, unique = false)
    private String validity;
    
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public String getQuantityInStock() {
        return quantityInStock;
    }
    public void setQuantityInStock(String quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
    public String getValidity() {
        return validity;
    }
    public void setValidity(String validity) {
        this.validity = validity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    
}
