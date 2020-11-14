package com.tisuela;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Receipt {

    private static final List<String> taxExemptGoods = Arrays.asList(
            "food",
            "chocolate",
            "chocolates",
            "book",
            "books",
            "pill",
            "pills",
            "medicine"
    );


    private List<Item> items;




    public Receipt() {
        items = new ArrayList<>();
    }

    public void addItem(Item item){
        /*
        add an item to the receipt after checking what kind of item it is
         */


        if (this.itemIsTaxExcempt(item)){
            item = new TaxExemptItem(item);
        }

        // check if item is imported last, since that has highest priority for defining tax rate
        if (this.itemIsImported(item)){
            item = new ImportedItem(item);
        }

        items.add(item);
    }

    private boolean itemIsTaxExcempt(Item item){
        /*
        Check if item is tax excempt by checking if a word in the item name is in
        a list of key words for tax excempt goods
         */

        // faster to iterate over words in name than words in key words
        for(String word: item.getName().split(" ")){
            if (taxExemptGoods.contains(word)){
                return true;
            }
        }

        return false;
    }

    private boolean itemIsImported(Item item){
        /*
        Check if item is imported by checking for key word
         */
        return item.getName().contains("imported");
    }


    public BigDecimal getSalesTax(){
        BigDecimal salesTax = new BigDecimal(0);

        for (Item item: items){
            salesTax = salesTax.add(item.getSalesTax());
        }

        return salesTax;
    }

    public BigDecimal getTotal(){
        BigDecimal total = new BigDecimal(0);

        for (Item item: items){
            total = total.add(item.getFullPrice());
        }

        return total;
    }


    public String toString(){
        StringBuilder result = new StringBuilder("--- Receipt ---\n");
        for (Item item: items){
            result.append(item.toString()).append("\n");
        }

        result.append("Sales Taxes: ").append(getSalesTax()).append("\n");
        result.append("Total: ").append(getTotal()).append("\n");


        return result.toString();
    }
}
