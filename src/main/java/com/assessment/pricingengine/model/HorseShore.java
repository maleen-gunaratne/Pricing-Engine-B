package com.assessment.pricingengine.model;

import javax.persistence.*;

@Entity
@Table(name="TBL_HORSESHORE")
public class HorseShore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="unit_price")
    private Double unitPrice;

    @Column(name="cartoon_price")
    private Integer cartoonPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getCartoonPrice() {
        return cartoonPrice;
    }

    public void setCartoonPrice(Integer cartoonPrice) {
        this.cartoonPrice = cartoonPrice;
    }




}
