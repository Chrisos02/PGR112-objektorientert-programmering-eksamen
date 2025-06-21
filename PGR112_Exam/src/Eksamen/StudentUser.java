package Eksamen;

import java.sql.*;
import java.util.Scanner;


public class StudentUser {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // I used a scanner to capture and handle user inputs
        boolean exit = false;

        while (!exit) { // I used a while loop to keep it going, until a user choose option: exit.
            System.out.println("Welcome! Here are your options:");
            System.out.println("1. Sign in");
            System.out.println("2. See overall program");
            System.out.println("3. Exit");

            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                String username = signIn(input);
                Options(input, username);
                exit = true;
                input.nextLine();
                break;
                case 2: SeeOverallProgram(); // This way of structuring the code makes it look clean and user-friendly.
                exit = true;
                input.nextLine();
                break;
                case 3:
                    exit = true;
                    System.out.println("Exit successful!");
                    break;
                default:
                    System.out.println("please choose again!");
            }
        }
         input.close(); // closes the scanner
    }
    //# METHOD
    public static String signIn(Scanner input) {
        System.out.println("Please enter your first name:");
        String firstName = input.next();
        System.out.println("Please enter your last name:");
        String lastName = input.next();
        System.out.println("Welcome, " + firstName + " " + lastName + "!" );

        try(Connection connection = University_Database.getconnection(); // Connection to the database with methode from the university_database class.
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Students (first_name, last_name) VALUES (?, ?)")) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.executeUpdate(); // Execute the prepared statement, and insert name into "Students" table.
            System.out.println(firstName + lastName);
        } catch (SQLException e) { //finds sql errors
            e.printStackTrace();
        }
        return firstName + " " + lastName; // return full name
    } // Reference: kristiania/PGR112-23V/blob/master/code/lectures/_21/library/Library.java

    // METHOD
    public static void SeeOverallProgram() {
        System.out.println("Programs:");
        System.out.println("1. VisualAnalytics");
        System.out.println("2. Informasjonssikkerhet");
        System.out.println("3. OOP");
        System.out.println("4. Databaser");
    } //


    private static void Options(Scanner input, String username) {
        boolean userExit = false;

        System.out.println("Here are your options:");
        System.out.println("1. Register for the event");
        System.out.println("2. Search for participant");
        System.out.println("3. Sign out");

        int choice = input.nextInt();
        input.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Are you a student? (yes/no)");
                String isStudent = input.next();
                input.nextLine(); // Reference: https://www.w3schools.com/java/ref_string_equalsignorecase.asp
                if (!isStudent.equalsIgnoreCase("yes")){ // The response of the user is captured in the variable isStudent
                    System.out.println("Only students can register for event"); // If the user responds with yes, method registerEvent(input, username) is called
                } else {
                registerEvent(input, username);
                }
                break;
            case 3:
                System.out.println("Goodbye "  + username + "!");
                userExit = true;
                break;
            default:
                System.out.println("Please choose again!");
        }
    }
   public static void registerEvent(Scanner input, String username) {
       System.out.println("Register for the event, Enter StudentID:");
       String id = input.nextLine();
       System.out.println("Enter event name:");
       String name = input.nextLine();

       Event event = new Event(id, name, username);
       System.out.println("Guest name:");
       String guestName = input.nextLine();
       Guest guest = new Guest(guestName);
       event.addGuests(guest);
       System.out.println(event);
   }
}


























