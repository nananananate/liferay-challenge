package com.tisuela;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
	// write your code here



        Scanner scanner = new Scanner(System.in);

        String itemFormat = "<amount> <item name> at <price>";


        String example = "1 imported health pills at 24.45";

        System.out.println("Make your shopping bag to get your receipt!");
        System.out.println("To add an item, type: "+ itemFormat);
        System.out.println("Example: " + example);

        boolean creatingShoppingBag = true;

        while (creatingShoppingBag) {

            Receipt receipt = new Receipt();
            boolean addingItems = true;
            while (addingItems) {

                System.out.println("Enter item (leave blank to proceed to Checkout): ");
                String itemInput = scanner.nextLine();

                // if input is empty, break out of loop (to display receipt).
                if (itemInput.length() < 1) {
                    break;
                }

                String[] itemInputWords = itemInput.split(" ", 2);

                // make sure there are enough arguments
                if (itemInputWords.length < 2) {
                    System.out.println("Looks like you did not include enough item information");
                    System.out.println("Expected input: <amount> <item name> at <price>");
                    System.out.println("Received: " + itemInput);
                    continue;
                }

                // initialize amount
                int itemAmount = 0;

                // catch number format exceptions
                try {
                    itemAmount = Integer.parseInt(itemInputWords[0]);
                } catch (NumberFormatException e) {
                    System.out.println("Amount was not a whole number. Please specify a whole number for amount.");
                    continue;
                }

                String[] itemNameAndPrice = itemInputWords[1].split(" at ", 2);

                // make sure price is specified
                if (itemNameAndPrice.length < 2) {
                    System.out.println("Price was not specified. Please specify price using: at <price>");
                    System.out.println("Expected input: <amount> <item name> at <price>");
                    System.out.println("Received: " + itemInput);
                    continue;
                }

                String itemName = itemNameAndPrice[0];

                // init item price
                double itemPrice = 0;

                // catch number format exceptions
                try {
                    itemPrice = Double.parseDouble(itemNameAndPrice[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Price was not a number. Please specify a positive number for price using: at <price>");
                    System.out.println("Expected input: <amount> <item name> at <price>");
                    System.out.println("Received: " + itemInput);
                    continue;
                }

                // make sure price is positive
                if (itemPrice < 0) {
                    System.out.println("Price cannot be a negative number. Please specify a positive number for price using: at <price>");
                    continue;
                }

                // create item
                Item item = new Item(itemName, itemPrice, itemAmount);

                // add item to receipt
                receipt.addItem(item);
            }

            System.out.println(receipt);


            // Check if user wants to create another shopping bag
            System.out.println("Would you like to create another shopping bag? (Y/n)");
            String choice = scanner.nextLine().trim();

            if (choice.equals("Y")) {
                System.out.println("Make another shopping bag!");
                continue;
            }
            else {
                creatingShoppingBag = false;
            }
        }

        System.out.println("Thanks for your purchase! Bye!");
    }
}
