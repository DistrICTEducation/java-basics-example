package ui;

import java.util.InputMismatchException;
import java.util.Scanner;
import system.Library;

/**
 * A text-based user interface for the library application. The TBUI
 * class provides methods for reading input from the console.
 *
 * @author Joris Schelfaut, Wouter Moermans, Prince Ansong, Bart Horre
 */
public abstract class TBUI extends UserInterface {
    
    private final Scanner scanner;
    private final String TRY_AGAIN_MSG = "Wrong input, please try again.";

    public TBUI(Library library) {
        super(library);
        this.scanner = new Scanner(System.in);
    }

    /**
     * @return the scanner to read input from the console.
     */
    Scanner getScanner() {
        return scanner;
    }

    /**
     * @param min the lowest possible expected input value.
     * @param max the highest possible expected input value.
     * @return the integer read from the console.
     */
    protected int readInt(int min, int max) {
        int result = min - 1;
        while (result < min || result > max) {
            try {
                result = scanner.nextInt();
                if (result > max || result < min) System.out.println(TRY_AGAIN_MSG);
            } catch (InputMismatchException ex) {
                scanner.nextLine();
                System.out.println(TRY_AGAIN_MSG);
                result = min - 1;
            }
        }
        return result;
    }

    /**
     * @param min the lowest possible expected input value.
     * @param max the highest possible expected input value.
     * @return the double value read from the console.
     */
    protected double readDouble(double min, double max) {
        double result = min - 1;
        while (result < min || result > max) {
            try {
                result = scanner.nextDouble();
                if (result > max || result < min) {
                    System.out.println("Wrong input, try again.");
                }
            } catch (InputMismatchException ex) {
                scanner.nextLine();
                System.out.println("Wrong input, try again.");
                result = min - 1;
            }
        }
        return result;
    }

    /**
     * @return the integer read from the console.
     */
    protected String readString() {
        String result = "";
        while (result.equals("")) {
            try {
                result = scanner.nextLine();
            } catch (InputMismatchException ex) {
                scanner.nextLine();
                System.out.println("Wrong input, try again.");
                result = "";
            }
        }
        return result;
    }

    /**
     * @return the boolean value of "y" or "n" read from the console.
     */
    protected boolean readYN() {
        String result = "";
        while (result.equals("")) {
            String in = scanner.nextLine();
            if (in.equalsIgnoreCase("y") || in.equalsIgnoreCase("n"))
                result = in;
            else System.out.println("Please type either 'y' or 'n'.");
        }
        return result.equals("y");
    }
}