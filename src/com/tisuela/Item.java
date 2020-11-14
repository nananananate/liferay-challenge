package com.tisuela;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Item {


    private String name;

    protected int amount;

    private BigDecimal price;
    protected BigDecimal taxRate = new BigDecimal(0.1);
    private BigDecimal salesTax;
    private BigDecimal fullPrice;

    public Item(String name, BigDecimal price, BigDecimal taxRate, int amount){
        this.name = name;
        this.price = price;
        this.taxRate = taxRate;
        this.amount = amount;

        // set salesTax before fullPrice
        this.setSalesTax();

        // after setting salesTax. set fullPrice
        this.setFullPrice();
    }

    public Item(Item item){
        this(item.name, item.price, item.taxRate, item.amount);
    }

    public Item(String name, double price, int amount){
        this.name = name;
        this.amount = amount;
        this.price = new BigDecimal(price).setScale(
                2,
                RoundingMode.HALF_UP
        );

        // set salesTax before fullPrice
        this.setSalesTax();

        // after setting salesTax. set fullPrice
        this.setFullPrice();
    }

    public Item(String name, double price){
        this(name, price, 1);
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        BigDecimal decimalPrice = new BigDecimal(price).setScale(
                2,
                RoundingMode.HALF_UP
        );
        this.price = decimalPrice;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;

        // propogate changes to sales tax and final price
        this.setSalesTax();
        this.setFullPrice();
    }

    public void setSalesTax() {
        BigDecimal roundingIncrement = new BigDecimal(0.05);

        BigDecimal unroundedSalesTax = this.price.multiply(this.taxRate);
        //System.out.println(unroundedSalesTax);

        // preparation to round up to the nearest increment (0.05)
        BigDecimal dividedSalesTax = unroundedSalesTax.divide(roundingIncrement,0, RoundingMode.UP);
        //System.out.println(dividedSalesTax);

        // finalize rounding
        this.salesTax = dividedSalesTax.multiply(roundingIncrement).setScale(
                2,
                RoundingMode.HALF_UP
        );


    }

    public void setFullPrice() {
        fullPrice = price.add(salesTax).multiply(new BigDecimal(amount)).setScale(
                2,
                RoundingMode.HALF_UP
        );
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public BigDecimal getSalesTax() {
        return salesTax;
    }

    public BigDecimal getFullPrice() {
        return fullPrice;
    }

    public String toString(){
        return amount + " " + name + ": " + fullPrice;
    }
}
