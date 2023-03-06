package com.indizen.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "exchangerates")
public class ExchangeRates implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "country")
    private String country;
    @Column(name = "currency")
    private String currency;
    @Column(name = "price")
    private float price;

    public ExchangeRates() {
    }

    public ExchangeRates(long id, String country, String currency, float price) {
        this.id = id;
        this.country = country;
        this.currency = currency;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getCurrency() {
        return currency;
    }

    public float getPrice() {
        return price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setPrice(float price) {
        this.price =  price;
    }

    @Override
    public String toString() {
        return "ExchangeRates{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", currency='" + currency + '\'' +
                ", price=" + price +
                '}';
    }
}
