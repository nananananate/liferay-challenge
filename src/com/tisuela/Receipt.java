package com.tisuela;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<Item> items;

    public Receipt() {
        items = new ArrayList<Item>();
    }

    public void addItem(Item item){
        items.add(item);
    }


    public String toString(){
        String result = "--- Receipt ---\n";
        for (Item item: items){
            result += item.toString() + "\n";
        }

        return result;
    }
}
