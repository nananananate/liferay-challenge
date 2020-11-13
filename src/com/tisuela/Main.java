package com.tisuela;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Item testItem = new Item("test", 10);
        System.out.println(testItem);

        Item testTaxExemptItem = new TaxExemptItem("test Tax Exempt", 10);
        System.out.println(testTaxExemptItem);

        ImportedItem testImportedTaxExemptItem = new ImportedItem(testTaxExemptItem);
        System.out.println(testImportedTaxExemptItem);

        ImportedItem testImportedItem = new ImportedItem(testItem);

        System.out.println(testImportedItem);
        System.out.println(testItem);


        Receipt testReceipt = new Receipt();

        testReceipt.addItem(testItem);
        testReceipt.addItem(testImportedItem);
        testReceipt.addItem(testTaxExemptItem);
        testReceipt.addItem(testImportedTaxExemptItem);

        System.out.println(testReceipt);

    }
}
