package com.tisuela;

import java.util.Scanner;

public class Main {



    public static void main(String[] args) {
	// write your code here

        Receipt receipt = new Receipt();

        Scanner scanner = new Scanner(System.in);

        boolean flag = true;

        while (flag) {

            System.out.println("Enter item (leave blank if done): ");
            String itemInput = scanner.nextLine();

            if (itemInput.length() < 1){
                break;
            }
            String[] itemInputWords = itemInput.split(" ", 2);
            int itemAmount = Integer.parseInt(itemInputWords[0]);
            String[] itemNameAndPrice = itemInputWords[1].split(" at ", 2);

            String itemName = itemNameAndPrice[0];

            double itemPrice = Double.parseDouble(itemNameAndPrice[1]);
            Item item = new Item(itemName, itemPrice, itemAmount);
            receipt.addItem(item);
        }

        System.out.println(receipt);


    }
}
