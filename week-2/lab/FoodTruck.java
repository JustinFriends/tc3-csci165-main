//Justin Friends
//CSCI 165 Java
//FoodTruck Lab  Due 2/7/2020

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;
import java.io.PrintWriter; 

public class FoodTruck {

    public static void main(String[] args) {

        final int SIZE_OF_ARRAYS = 3; 
        final double TAX_RATE = 6.25;

        try{

            String[] menu = new String[SIZE_OF_ARRAYS];
            double[] prices = new double[SIZE_OF_ARRAYS];
            int[] quantity = new int[SIZE_OF_ARRAYS];
            File fileMenu = new File("menu.txt");
            File filePrices = new File("prices.txt");
            Scanner menuScanner = new Scanner(fileMenu);
            Scanner pricesScanner = new Scanner(filePrices);
            Scanner nameInput = new Scanner(System.in);
            Scanner quantityInput = new Scanner(System.in);
            int counter = 0, counter2 = 0;
            String name;

            while(menuScanner.hasNextLine()){
                String menuItem = menuScanner.nextLine();
                menu[counter] = menuItem;
                counter++;
            }

            while(pricesScanner.hasNextLine()){
                double priceItem = pricesScanner.nextDouble();
                prices[counter2] = priceItem;
                counter2++;
            }

            //Making sure arrays are populating properly.
            //System.out.printf("This is menu array: %s and %s and %s \n", menu[0], menu[1], menu[2]);
            //System.out.printf("This is prices array: %.2f and %.2f and %.2f \n", prices[0], prices[1], prices[2]);

            System.out.println("Welcome to the CS food truck.\n");
            System.out.println("Please enter your name: ");
            name = nameInput.nextLine();

            //Check for name variable working.
            //System.out.println(name);

            System.out.println("Enter the quantity of each item:");
            System.out.println("==============================\n");

            for(int x = 0; x < SIZE_OF_ARRAYS; x++){
                System.out.printf("%s - $%.2f\n", menu[x], prices[x]);
                quantity[x] = quantityInput.nextInt();
            }
            System.out.println();

            //Checking quantity array.
            //System.out.printf("This is quantity array: %d and %d and %d\n", quantity[0], quantity[1], quantity[2]);

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            DateTimeFormatter timeInvoiceFormatter = DateTimeFormatter.ofPattern("hh:mm");
            DateTimeFormatter dateGeneratorFormatter = DateTimeFormatter.ofPattern("MMdd");
            DateTimeFormatter timeGeneratorFormatter = DateTimeFormatter.ofPattern("HHmm");
            LocalDateTime dateTime = LocalDateTime.now();
            String dateString = dateFormatter.format(dateTime);
            String timeString = timeFormatter.format(dateTime);
            String timeInvoiceString = timeInvoiceFormatter.format(dateTime);
            String dateGenerator = dateGeneratorFormatter.format(dateTime);
            String timeGenerator = timeGeneratorFormatter.format(dateTime);

            //Checking for correct date and time in correct format.
            //System.out.println("Date: " + dateString);
            //System.out.println("Time: " + timeString);

            String invoice = name + " " + dateGenerator + " " + timeGenerator;

            //Check for invoice concatenation.
            //System.out.println(invoice);

            double quantityTotal = 0, subtotal = 0;

            for(int y = 0; y < SIZE_OF_ARRAYS; y++){
                quantityTotal = prices[y] * quantity[y];
                subtotal = subtotal + quantityTotal;
                quantityTotal = 0;
            }

            double tax = subtotal * (TAX_RATE / 100);
            double total = subtotal + tax;

            String pattern1 = "$###,###,###.00";
            DecimalFormat currency = new DecimalFormat(pattern1);

            
            String invoicePrint = InvoiceCreator(invoice);
            String fileName = invoicePrint + ".txt";
            
            PrintWriter invoiceWriter = new PrintWriter(fileName);

            String itemReceipt = "Item", quantityReceipt = "Quantity", priceQuantity = "Price", totalQuantity = "Total",
            subtotalReceipt = "Subtotal", salesTaxReceipt = TAX_RATE + "% Sales Tax", totalReceipt = "Total", 
            seperator = "===============================================================\n";

            System.out.printf("Invoice Number: %s\n", invoicePrint);
            System.out.printf("Date: %s\n", dateString);
            System.out.printf("Time: %s\n\n", timeString);
            System.out.printf("%-30s %10s %10s %10s\n", itemReceipt, quantityReceipt, priceQuantity, totalQuantity);
            System.out.printf("%s\n", seperator);
            for(int z = 0; z < SIZE_OF_ARRAYS; z++){
                System.out.printf("%-30s %10d %10s %10s\n\n", menu[z], quantity[z], currency.format(prices[z]), currency.format(quantity[z] * prices[z]));
            }
            System.out.printf("%s\n", seperator);
            System.out.printf("%-40s %22s\n\n", subtotalReceipt, currency.format(subtotal));
            System.out.printf("%-40s %22s\n\n", salesTaxReceipt, currency.format(tax));
            System.out.printf("%-40s %22s\n\n", totalReceipt, currency.format(total));

            invoiceWriter.printf("Invoice Number: %s\n", invoicePrint);
            invoiceWriter.printf("Date: %s\n", dateString);
            invoiceWriter.printf("Time: %s\n\n", timeString);
            invoiceWriter.printf("%-30s %10s %10s %10s\n", itemReceipt, quantityReceipt, priceQuantity, totalQuantity);
            invoiceWriter.printf("%s\n", seperator);
            for(int z = 0; z < SIZE_OF_ARRAYS; z++){
                invoiceWriter.printf("%-30s %10d %10s %10s\n\n", menu[z], quantity[z], currency.format(prices[z]), currency.format(quantity[z] * prices[z]));
            }
            invoiceWriter.printf("%s\n", seperator);
            invoiceWriter.printf("%-40s %22s\n\n", subtotalReceipt, currency.format(subtotal));
            invoiceWriter.printf("%-40s %22s\n\n", salesTaxReceipt, currency.format(tax));
            invoiceWriter.printf("%-40s %22s\n\n", totalReceipt, currency.format(total));



            menuScanner.close();
            pricesScanner.close();
            nameInput.close();
            quantityInput.close();
            invoiceWriter.close();
            
        } //Try end.
        catch (IOException e){
            System.out.println("There was a problem writing to the file.");
        }
        //catch (FileNotFoundException fnf){
        //    System.out.println("Error: File Not Found.");
        //}
            
            
    }

    public static String InvoiceCreator(String invoice){
        String invoiceNumber = "SetMe";

        //Check for parameter passing and function call, or in Java, method definitions apparently.
        //System.out.println(invoice);

        int firstSpace = invoice.indexOf(' ');
        int secondSpace = invoice.indexOf(' ', firstSpace + 1);
        int thirdSpace = invoice.indexOf(' ', secondSpace + 1);
        int nameLength = secondSpace;
        String date = invoice.substring(secondSpace + 1, thirdSpace);
        //Checking for correct date substring.
        //System.out.println("Date: " + date);
        String time = invoice.substring(thirdSpace + 1);
        //Checking for correct time substring.
        //System.out.println("Time: " + time);
        String initial1 = String.valueOf(invoice.charAt(0)), initial2 = String.valueOf(invoice.charAt(1)), 
        initial3 = String.valueOf(invoice.charAt(firstSpace + 1)), initial4 = String.valueOf(invoice.charAt(firstSpace + 2));

        initial1 = initial1.toUpperCase();
        initial2 = initial2.toUpperCase();
        initial3 = initial3.toUpperCase();
        initial4 = initial4.toUpperCase();

        //Checking for correct initials.
        //System.out.printf("Test of initials: %s and %s and %s and %s\n", initial1, initial2, initial3, initial4);
        
        //Number convert check.
        //int initial1Value = initial1.codePointAt(0);
        //int initial3Value = initial3.codePointAt(0);
        //System.out.printf("First initial: %d and second: %d and length: %d\n", initial1Value, initial3Value, nameLength);

        int numGenerated = (initial1.codePointAt(0) + initial3.codePointAt(0)) * nameLength;

        //Check for correct math output.
        //System.out.println(numGenerated);

        invoiceNumber = initial1 + initial2 + initial3 + initial4 + Integer.toString(numGenerated) + date + time;

        return invoiceNumber;
    }
}