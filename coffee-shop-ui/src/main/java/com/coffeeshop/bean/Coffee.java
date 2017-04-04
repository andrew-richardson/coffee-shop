package com.coffeeshop.bean;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by andrew on 4/2/17.
 */
public class Coffee {
    private UUID id;
    private String name;
    private BigDecimal price;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
