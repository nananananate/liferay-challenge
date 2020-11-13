package com.tisuela;

import java.math.BigDecimal;

public class ImportedItem extends Item{
    protected BigDecimal importedTaxRate = new BigDecimal(0.05);

    public ImportedItem(String name, double price){
        super(name, price);

        BigDecimal newTaxRate = this.importedTaxRate.add(super.taxRate);
        this.setTaxRate(newTaxRate);

    }

    public ImportedItem(Item item){
        /*
        Construct from another item, which may have a different tax rate
         */
        super(item);
        BigDecimal newTaxRate = this.importedTaxRate.add(this.taxRate);
        this.setTaxRate(newTaxRate);
    }
}
