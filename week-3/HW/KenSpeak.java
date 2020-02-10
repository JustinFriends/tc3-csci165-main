//Justin Friends
//CSCI 165 Java
//HW 3 due 2/10/20

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class KenSpeak {

    public static void main(String[] args) {
        
        System.out.println("This is problem 1: Entering a number to be encoded to the console.\n");

        try{
    
            Scanner inputNumber = new Scanner(System.in);

            System.out.println("Enter the number to be encoded: \n");
            String inputText = inputNumber.nextLine();
            //System.out.println(inputText);

            System.out.println(Encode(inputText));

            inputNumber.close();

        }
        catch (NumberFormatException e) {
            System.out.println("You didn't enter a number.");
        }

        System.out.println();
        System.out.println("This is problem 2: Reading numbers from a file and encoding them into a different file.");

        try {    
            File fileNumbers = new File("numbers.txt");
            Scanner numbersScanner = new Scanner(fileNumbers);
            FileWriter encodedNumberWriter = new FileWriter("encodedNumbers.txt");

            while(numbersScanner.hasNextLine()){
                String numberRead = numbersScanner.nextLine();
                StringBuilder encodedNumber = new StringBuilder(Encode(numberRead));
                encodedNumberWriter.append(encodedNumber + "\n");
            }

            numbersScanner.close();
            encodedNumberWriter.close();

        }
        catch (FileNotFoundException fnf){
            System.out.println("File was not found.");
        }
        catch (IOException a){
            System.out.println("There was a problem writing to the file.");
        }

    } //End void main String.

    public static StringBuilder Encode(String inputText){

        //Encoding key.
        String codes = "*BEA@FK%RM";
        int input = Integer.parseInt(inputText);

        int inputLength = inputText.length();

            String numBackwards = "";

            while(input > 0) {
                int remainder = input % 10;
                //Check for correct remainders.
                //System.out.println("Remainder: \n" + remainder);
                char digit = codes.charAt(remainder);
                //Check for correct conversion.
                //System.out.println("Corresponding digit: \n" + digit);
                input = input / 10;
                //Check for correct rest of the number.
                //System.out.println("What's left of the number: \n" + var2);
                numBackwards = numBackwards + digit;
            }

            StringBuilder numForwards = new StringBuilder();        
            int leadingZeroes = inputLength - numBackwards.length();

            if(leadingZeroes > 0){
                for(int x = 0; x < leadingZeroes; x++){
                    numBackwards = numBackwards + "*";
                }
                numForwards.append(numBackwards);
                numForwards = numForwards.reverse();
                //System.out.println(numForwards);
            }
            else {
                numForwards.append(numBackwards);
                numForwards = numForwards.reverse();
                //System.out.println(numForwards);
            }

        return numForwards;
    } //End Encode StringBuilder.

} //End public class.