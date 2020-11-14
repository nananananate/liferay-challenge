package com.tisuela;

import java.math.BigDecimal;

public class TaxExemptItem extends Item{

    public TaxExemptItem(String name, double price, int amount){
        super(name, price, amount);

        BigDecimal newTaxRate = new BigDecimal(0);
        this.setTaxRate(newTaxRate);
    }

    public TaxExemptItem(String name, double price){
        this(name, price, 1);
    }

    public TaxExemptItem(Item item){
        /*
        Construct from another item, which may have a different tax rate
         */
        super(item);
        BigDecimal newTaxRate = new BigDecimal(0);
        this.setTaxRate(newTaxRate);
    }

}
