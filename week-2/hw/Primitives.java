//Justin Friends
//CSCI 165 Java
//Homework  Due 2/3/2020

import java.lang.Math;
import java.util.Scanner;
import java.lang.Integer;


public class Primitives {
    
    public static void main(String[] args) {

        //Problem 1:
        System.out.println("Problem 1:\n");

        //Defining and initializing all primitive data types.
        byte dataTypeByte = 124;
        short dataTypeShort = 24571;
        int dataTypeInt = 42;
        long dataTypeLong = 398;
        float dataTypeFloat = 24;
        double dataTypeDouble = 54;
        boolean dataTypeBoolean = false;
        char dataTypeChar = 'D';

        //Printing each value using printf.
        System.out.printf("These are the values: %d; %d; %d; %d, %.4f, %.2f, %b; and %c", dataTypeByte, dataTypeShort, dataTypeInt, dataTypeLong, 
        dataTypeFloat, dataTypeDouble, dataTypeBoolean, dataTypeChar);
        System.out.println();
        System.out.println();

        //Demonstrating character and numeric literals for char type.
        int charLiteral = 67;
        System.out.printf("Here is the char character: %c and the char numeral: %d.\n", charLiteral, charLiteral); //Because of Java's use of unicode, 
        //it follows ASCII values (until it goes past as far as ASCII goes), which means every character has a numeric value and therefore can print 
        //the integer values as characters.
        System.out.println();

        //Widening and narrowing type casts.
        int intCast = 4;
        double doubleCast = 7.85;
        double intToDouble = intCast;
        int doubleToInt = (int) doubleCast;

        System.out.println("This is widening, from integer value " + intCast + " to double value " + intToDouble);
        System.out.println("This is narrowing, from double value " + doubleCast + " to integer value " + doubleToInt);
        System.out.println();


        //Problem 2:
        System.out.println("Problem 2:\n");

        //Create scanner object for input stream.
        Scanner input = new Scanner(System.in);
        //Define and initalize int variable.
        int var = 0;
        System.out.println("Please enter an integer to be squared, cubed, and quarted.");
        var = input.nextInt();

        System.out.println("You entered " + var + ". The square is: " + Math.pow(var, 2) + ". The cube is: " + Math.pow(var, 3) + ". The quartic is: " + Math.pow(var, 4));
        System.out.println();

        //input.close();


        //Problem 3:
        System.out.println("Problem 3:\n");

        //Defining int values with min and max constants.
        int x = Integer.MAX_VALUE;
        int y = Integer.MIN_VALUE;

        System.out.printf("The max integer value is: %d. The min integer value is: %d.", x, y);
        System.out.println();
        System.out.println();

        //Comparing signed and unsigned integers.
        System.out.println("Max compared to Min signed: " + Integer.compare(x, y)); //This outputs 1, meaning the first compared value of MAX is greater
        //than the second compared value of MIN, because signed int MAX is greater than signed int MIN.
        System.out.println("Max compared to Min unsigned: " + Integer.compareUnsigned(x, y)); //This outputs -1, meaning the first compared value of MAX
        //is less than the second compared value of MIN, because when it's converting the signed int to an unsigned int the whole range becomes positive 
        //and the negative int rolls over and becomes the combined max value of the range minus what its negative, signed value was. 


        //Problem 4
        System.out.println("Problem 4:\n");
        double doubleInput = 0;
        float floatInput = 0;

        System.out.println("Enter a floating point number");
        doubleInput = input.nextDouble();
        System.out.println("Enter another floating point number");
        floatInput = input.nextFloat();

        boolean finiteDouble = Double.isFinite(0 / doubleInput), finiteFloat = Float.isFinite(0 / floatInput);

        System.out.printf("Using the isFinite() method for double, 0 / %f is %b, and for float, 0 / %f is %b\n", doubleInput, finiteDouble, floatInput, finiteFloat);

        //Demonstrating a true and false value. - I couldn't get a false value, I 'm not sure what I'm doing wrong.
        double trueValue = 1.0 / 3.0, falseValue = 3;
        boolean trueDemonstration = Double.isFinite(trueValue), falseDemonstration = Double.isFinite(falseValue);

        System.out.printf("Example of true and false values, starting with %f returning %b, and %f returning %b\n", trueValue, trueDemonstration, falseValue, falseDemonstration);


        //Problem 5
        System.out.println("Problem 5:\n");

        //Scanner input2 = new Scanner(System.in);
        int dividend = 0, divisor = 0, answerFloor = 0, answerDiv = 0, remainderFloor = 0, remainderMod = 0;

        System.out.println("Enter an integer dividend:\n");
        dividend = input.nextInt();
        System.out.println("Enter an integer divisor:\n");
        divisor = input.nextInt();
        answerDiv = dividend / divisor;
        answerFloor = Math.floorDiv(dividend, divisor);
        remainderMod = dividend % divisor;
        remainderFloor = Math.floorMod(dividend, divisor);

        System.out.printf("You entered %d and %d, the division operator is: %d and the division floor is: %d\n", dividend, divisor, answerDiv, answerFloor);
        System.out.printf("The modulus operator is: %d and the modulus floor is: %d", remainderMod, remainderFloor);
        
        input.close();
    }

}