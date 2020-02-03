//Justin Friends
//CSCI 165 Java
//Homework due 2/3/2020

import java.util.Scanner;

public class GMT {

    public static void main(String[] args) {

        //System.out.println(System.currentTimeMillis());

        long total = System.currentTimeMillis();
        //int seconds = (int) (total / 1000) % 60, minutes = (int) (total / (1000 * 60)) % 60, hours = (int) (total / (1000 * 60 * 60)) % 24;

        //System.out.printf("The time is: %02d:%02d:%02d\n", hours, minutes, seconds);

        System.out.println("Input the timezone difference to GMT: ");
        Scanner input = new Scanner(System.in);
        int timeDifference = input.nextInt();
        long timeMili = timeDifference * 60 * 60 * 1000;

        long total2 = System.currentTimeMillis() + timeMili;
        int seconds = (int) (total2 / 1000) % 60, minutes = (int) (total2 / (1000 * 60)) % 60, hours = (int) (total2 / (1000 * 60 * 60)) % 24;

        System.out.printf("The current time is: %02d:%02d:%02d\n", hours, minutes, seconds);

        input.close();
    }

}