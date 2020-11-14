# [Liferay Challenge](http://liferay-challenge.tisuela.com/)
This is Nathaniel Louis Tisuela's solution to the Sales Taxes Problem.

My solution is a Java CLI application. 

## Quick Start

Using your terminal, clone the repository and navigate into it. (Alternative: navigate to the files that have been sent via email).

```
git clone https://github.com/nananananate/liferay-challenge
cd liferay-challenge
```

To run the CLI app (a `.jar` file), use these commands:

Windows:

```
java -jar .\out\artifacts\challenge_jar\challenge.jar
```

You should now see this:

```
To add an item, type: <amount> <item name> at <price>
Example: 1 imported health pills at 24.45
Enter item (leave blank to proceed to Checkout):
```

You can now enter items and get your receipt! Happy shopping!

## CLI Usage

As per the previous instructions, use these commands to run the `.jar` file:

Windows:

```
java -jar .\out\artifacts\challenge_jar\challenge.jar
```

You should now see this:

```
To add an item, type: <amount> <item name> at <price>
Example: 1 imported health pills at 24.45
Enter item (leave blank to proceed to Checkout):
```

All items must be entered with the following format: `<amount> <item name> at <price>`.

To checkout, simply submit an empty line.

You should now see a receipt with items in the format of `<amount> <item>: <price include sales tax>`.

Here is an example receipt:

```
1 book: 12.49
1 music CD: 16.49
1 chocolate bar: 0.85
Sales Taxes: 1.50
Total: 29.83
```

After checkout, you have the option to keep shopping:

```
Would you like to create another shopping bag? (Y/n)
```

Simply enter `Y` if you would like to keep shopping. Any other input will end shopping. 

That's it.








