package com.tisuela;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
	// write your code here

        Receipt receipt = new Receipt();

        Scanner scanner = new Scanner(System.in);

        boolean flag = true;

        String itemFormat = "<amount> <item name> at <price>";
        String example = "1 imported health pills at 24.45";
        System.out.println("Make your shopping bag!");
        System.out.println("To add an item, type: "+ itemFormat);
        System.out.println("Example: " + example);

        while (flag) {

            System.out.println("Enter item (leave blank if done): ");
            String itemInput = scanner.nextLine();

            if (itemInput.length() < 1){
                break;
            }

            String[] itemInputWords = itemInput.split(" ", 2);


            // make sure there are enough arguments
            if (itemInputWords.length < 2){
                System.out.println("Looks like you did not include enough item information");
                System.out.println("Expected input: <amount> <item name> at <price>");
                System.out.println("Received: "+ itemInput);
                continue;
            }

            // initialize amount
            int itemAmount = 0;

            // catch number format exceptions
            try {
                itemAmount = Integer.parseInt(itemInputWords[0]);
            }
            catch(NumberFormatException e) {
                System.out.println("Amount was not a whole number. Please specify a whole number for amount.");
                continue;
            }

            String[] itemNameAndPrice = itemInputWords[1].split(" at ", 2);

            String itemName = itemNameAndPrice[0];

            double itemPrice = Double.parseDouble(itemNameAndPrice[1]);
            Item item = new Item(itemName, itemPrice, itemAmount);
            receipt.addItem(item);
        }

        System.out.println(receipt);


    }
}
