import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

//Justin Friends and Stephan Wagner
//

public class Tickets{

    public static void main(String[] args){

        /* 
            The following code steps you through the String processing
            and math neccessary to determine if a single ticket number is valid.
            Your job with this code is to:

            ~   Closely study the code. Reverse engineer it. Use the API for guidance
                to understand the classes and methods that are being used.
            ~   Add comments for each statement, describing in detail what the line is doing
                I want to know DETAILS, not generalizations. RESEARCH!
            ~   When you have completed that, add code to complete the following

                1) Using a Scanner, open the file: tickets.txt
                2) Using a while(hasNext) loop, read each ticket number
                3) Run the ticket number through the provided math and String processing
                4) If the ticket number is valid write it to a new file called: valid_tix.txt
                5) Ignore the invalid ticket numbers

            ~   Additional code must also be commented. But I am more interested in why you are doing
                something, not the details of how.

            Check your work: There are 101 valid ticket numbers among the 1000 provided ticket numbers
                             These people make mistakes!!!

            Submit only Java source code files. Also submit valid_tix.txt   

        */

        //When connecting to file, must use try/catch.
        try{
            //Need to read from file.
            File text = new File("tickets.txt");
        
            //Scanner object is how you reference data from a source.
            Scanner fileScanner = new Scanner(text);
        
            //Counter to keep track of how many valid tickets there are.
            int validTickets = 0;

            try {
                FileWriter fileWriter = new FileWriter("valid_tix.txt");  // instantiate FileWriter

                //While loop to read new lines from the text file, so long as there are new lines to read.  
                //Otherwise it exits the loop.
                while(fileScanner.hasNextLine()){
                    // nextLine extracts data and advances the cursor
                    String ticket = fileScanner.nextLine();
                    //System.out.println("line " + lineNumber + ": " + line);

                    //write to file
                    boolean valid  = validateTicket(ticket);

                    if (valid) {
                         // instantiation of the FileWriter may throw an IOException, must be try/caught
                        fileWriter.write(ticket + "\n");             // writes to text file
                        validTickets++;
                    }
                } 

                // close the scanner to prevent a resource leak
                fileWriter.close();                 // closes writer, calling flush()
            } catch (IOException e) {
                System.out.println("There was a problem writing to the file");
            }

            fileScanner.close();
                
            System.out.printf("Valid tickets: %d", validTickets);

        } //end try
        catch(FileNotFoundException fnf){
            System.out.println("ERROR: FILE NOT FOUND!");
        } // end catch
    }

    /**
     * Validates number parameter based on removing the last digit, dividing the resulting number by 7, and checking to see if they're equal to each other.
     * @param ticket
     * @return boolean
     */
    public static boolean validateTicket(String ticket) {

        //Setting string variable ticket to 123454.
        //String  ticket  = "123454";

        //Identifying the last character of the string, accounting for starting position 0 in an array.
        String  last = ticket.substring(ticket.length() - 1);
        //Converting the string variable last to variable last_digit of data type integer.                                                
        int     last_digit = Integer.valueOf(last);
        //Setting string variable reduced_ticket, starting at position 0, to the remaining distance (since it's one character less now).
        String  reduced_ticket = ticket.substring(0, ticket.length() - 1);
        //Converting string variable reduced_ticket to int variable ticket_number.
        int     ticket_number = Integer.valueOf(reduced_ticket);
        //Getting the int variable remainder value by dividing the ticket_number by 7 using the mode operation. 
        int     remainder = ticket_number % 7;
        //Getting boolean value of true or false based on whether remainder is equal to last_digit.
        boolean validity = remainder == last_digit;
        //Setting string variable format to print, using placeholders; %s for string, %d for int, and %b for boolean.
        String  format = "Original Ticket #: %s\nLast Digit: %d\nReduced Ticket #: %d\nRemainder: %d\nValidity: %b\n";
        //Print command for the string variable format, substituting the variables ticket, last_digit, ticket_number, remainder, 
        //and validity for their corresponding data type placeholders in the string variable format.
        System.out.printf(format, ticket, last_digit, ticket_number, remainder, validity);

        return validity;
    }
}