//Justin Friends
//CSCI 165 Java
//Homework due 2/3/2020

import java.util.Scanner;

public class Initials {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String name;
        int nameLength = 0, spaceLocation = 0;
        char firstInitial, lastInitial;
        
        System.out.println("Please enter your first and last name.");
        name = input.nextLine();
        nameLength = name.length();
        spaceLocation = name.indexOf(' ');
        firstInitial = name.charAt(0);
        lastInitial = name.charAt(spaceLocation + 1);

        //System.out.println("Name length: " + nameLength);
        //System.out.println("Space position: " + spaceLocation);

        System.out.println("First initial: " + firstInitial);
        System.out.println("Last initial: " + lastInitial);
        System.out.println("The numerical value of first initial is: " + (int)firstInitial + " and last initial is: " + (int)lastInitial);
        System.out.println("The sum of the values are: " + (firstInitial + lastInitial));
        System.out.printf("The characters concatenated together: %c%c", firstInitial, lastInitial);

        input.close();
    }

}