package com.tisuela;

import java.math.BigDecimal;

public class TaxExemptItem extends Item{

    public TaxExemptItem(String name, double price){
        super(name, price);

        BigDecimal newTaxRate = new BigDecimal(0);
        this.setTaxRate(newTaxRate);
    }


}
