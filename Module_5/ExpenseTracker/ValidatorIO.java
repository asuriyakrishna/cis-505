package Module_5.ExpenseTracker;

import java.util.Scanner;

public class ValidatorIO {
    public static Integer getInt(Scanner sc, String prompt) {
        Integer input = 0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                input = sc.nextInt();
                isValid = true;
            } else {
                System.out.println("\n Error! Invalid integer value.\n");            
            }
            sc.nextLine();
        }
        return input;
    }
    public static double getDouble(Scanner sc, String prompt) {
        double input = 0.0;
        boolean isValid = false;

        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                input = sc.nextDouble();
                isValid = true;
            } else {
                System.out.println("Error! Invalid double value."); 
            }
            sc.nextLine();
        }

        return input;
    }
    public static String getString(Scanner sc, String prompt) {
        System.out.print(prompt);
        return sc.next();
    }

    public static boolean getYesNo(Scanner sc, String prompt) {
        boolean isValid = false;
        boolean result = false;

        while (!isValid) {
            System.out.println();
            System.out.print(prompt);
            String input = sc.next().toLowerCase();
            if (input.equals("y") || input.equals("yes")) {
                result = true;
                isValid = true;
            } else if (input.equals("n") || input.equals("no")) {
                result = false;
                isValid = true;
                System.out.println();
                System.out.println("  Program terminated by the user...");
            } else {
                System.out.println("Error! Please enter 'y' for yes or 'n' for no.");
            }
        }

        return result;
    }
}
