package ui;

import java.util.List;
import system.Book;
import system.Comic;
import system.DuplicateException;
import system.Item;
import system.Library;
import system.Magazine;
import system.Rating;

/**
 * The main view for the library application's text-based user interface.
 *
 * @author Joris Schelfaut
 */
public class TBUIMain extends TBUI {

    public TBUIMain(Library library) {
        super(library);
    }

    @Override
    public void show() {
        System.out.println("#######################################");
        System.out.println("# Welcome to the library application! #");
        System.out.println("#######################################");
        
        showMainMenu();
    }

    private void showMainMenu() {
        System.out.println("\n---------------------------------------");
        System.out.println("Please select an option :");
        System.out.println("1. Library contents overview.");
        System.out.println("2. Add a new item.");
        System.out.println("3. Stop the application.");
        System.out.println("---------------------------------------");

        int result = readInt(1, 3);
        switch (result) {
            case 1:
                showItemsOverview();
                break;
            case 2:
                showAddItemWizard();
                break;
            case 3:
                showExitMessage();
                break;
        }
    }

    private void showItemsOverview() {
        System.out.println("\n---------------------------------------");
        List<Item> items = getLibrary().getItems();
        for (int i = 0; i < items.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + items.get(i));
        }
        System.out.println("---------------------------------------");
        showMainMenu();
    }

    private void showExitMessage() {
        System.out.println("Goodbye!");
    }

    private void showAddItemWizard() {
        System.out.println("\n---------------------------------------");
        System.out.println("- New item wizard - Step 1            -");
        System.out.println("---------------------------------------");
        System.out.println("Please select an option :");
        System.out.println("1. Add new book.");
        System.out.println("2. Add new comic.");
        System.out.println("3. Add new magazine.");
        System.out.println("4. Show main menu.");
        
        int result = readInt(1, 4);
        switch (result) {
            case 1:
                showAddBookWizard();
                break;
            case 2:
                showAddComicWizard();
                break;
            case 3:
                showAddMagazineWizard();
                break;
            case 4:
                showMainMenu();
                break;
        }
        
    }

    private void showAddBookWizard() {
        System.out.println("\n---------------------------------------");
        System.out.println("- New item wizard - Step 2 (book)     -");
        System.out.println("---------------------------------------");
        
        System.out.print("\tTitle : ");
        String title = readString();
        
        System.out.print("\tAuthor : ");
        String author = readString();
        
        System.out.print("\tPublication year : ");
        int year = readInt(0, Integer.MAX_VALUE);
        
        System.out.print("\tRating {1:POOR, 2:AVERAGE, 3:GOOD, 4:EXCELLENT, 5:UNKNOWN} : ");
        int value = readInt(1, 5);
        Rating[] values = Rating.values();
        Rating rating = values[value - 1];
        
        System.out.print("\tISBN : ");
        String isbn = readString();
        
        try {
            Book book = new Book(title, author, year, rating, isbn);
            this.getLibrary().addItem(book);
            System.out.println("The item was successfully added to the library.");
        } catch (NullPointerException | DuplicateException ex) {
            printException(ex);
        }
        
        showItemsOverview();
    }

    private void showAddComicWizard() {
        System.out.println("\n---------------------------------------");
        System.out.println("- New item wizard - Step 2 (comic)    -");
        System.out.println("---------------------------------------");
        
        System.out.print("\tTitle : ");
        String title = readString();
        
        System.out.print("\tAuthor : ");
        String author = readString();
        
        System.out.print("\tPublication year : ");
        int year = readInt(0, Integer.MAX_VALUE);
        
        System.out.print("\tRating {1:POOR, 2:AVERAGE, 3:GOOD, 4:EXCELLENT, 5:UNKNOWN} : ");
        int value = readInt(1, 5);
        Rating[] values = Rating.values();
        Rating rating = values[value - 1];
        
        System.out.print("\tISSN : ");
        String issn = readString();
        
        System.out.print("\tSeries : ");
        String series = readString();
        
        System.out.print("\tNumber of series : ");
        int number = readInt(1, Integer.MAX_VALUE);
        
        try {
            Comic comic = new Comic(title, author, year, rating, issn, number, series);
            this.getLibrary().addItem(comic);
            System.out.println("The item was successfully added to the library.");
        } catch (NullPointerException | DuplicateException ex) {
            printException(ex);
        }
        showItemsOverview();
    }

    private void showAddMagazineWizard() {
        System.out.println("\n---------------------------------------");
        System.out.println("- New item wizard - Step 2 (magazine) -");
        System.out.println("---------------------------------------");
        
        System.out.print("\tTitle : ");
        String title = readString();
        
        System.out.print("\tAuthor : ");
        String author = readString();
        
        System.out.print("\tPublication year : ");
        int year = readInt(0, Integer.MAX_VALUE);
        
        System.out.print("\tRating {1:POOR, 2:AVERAGE, 3:GOOD, 4:EXCELLENT, 5:UNKNOWN} : ");
        int value = readInt(1, 5);
        Rating[] values = Rating.values();
        Rating rating = values[value - 1];
        
        System.out.print("\tISSN : ");
        String issn = readString();
        
        System.out.print("\tSeries : ");
        String series = readString();
        
        System.out.print("\tNumber of series : ");
        int number = readInt(1, Integer.MAX_VALUE);
        
        System.out.print("\tTopic : ");
        String topic = readString();
        
        try {
            Magazine magazine = new Magazine(title, author, year, rating, issn, number, series, topic);
            this.getLibrary().addItem(magazine);
            System.out.println("The item was successfully added to the library.");
        } catch (IllegalArgumentException | NullPointerException | DuplicateException ex) {
            printException(ex);
        }
        showItemsOverview();
    }
}
