import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import system.*;
import ui.*;

/**
 * Starts the application.
 * @author Joris Schelfaut
 */
public class Main {
    
    public static void main (String[] args) {
        
        // Instantiate a new library object :
        Library library = new Library();
        
        // Load some test data :
        try {
            loadData(library);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // User interaction :
        UserInterface userInterface = new TBUIMain(library);
        //UserInterface userInterface = new GUI(library);
        userInterface.show();
    }
    
    /**
     * Loads the library data from a CSV file (Comma-separated values).
     * @param library the library to load the data to.
     * @throws FileNotFoundException
     * @throws IOException 
     */
    private static void loadData(Library library) throws FileNotFoundException, IOException {
        
        BufferedReader in = new BufferedReader(new FileReader("data.csv"));
        
        while (in.ready()) {
            String line = in.readLine();
            if (line.startsWith("#")) continue;
            StringTokenizer csvReader = new StringTokenizer(line, ",");
            Item item = null;
            String type = csvReader.nextToken();
            try {
                if (type.equalsIgnoreCase("book")) {
                    item = new Book(csvReader.nextToken(),
                            csvReader.nextToken(),
                            Integer.parseInt(csvReader.nextToken()),
                            Rating.valueOf(csvReader.nextToken()),
                            csvReader.nextToken());
                } else if (type.equalsIgnoreCase("comic")) {
                    item = new Comic(csvReader.nextToken(),
                            csvReader.nextToken(),
                            Integer.parseInt(csvReader.nextToken()),
                            Rating.valueOf(csvReader.nextToken()),
                            csvReader.nextToken(),
                            Integer.parseInt(csvReader.nextToken()),
                            csvReader.nextToken());
                } else if (type.equalsIgnoreCase("magazine")) {
                    item = new Magazine(csvReader.nextToken(),
                            csvReader.nextToken(),
                            Integer.parseInt(csvReader.nextToken()),
                            Rating.valueOf(csvReader.nextToken()),
                            csvReader.nextToken(),
                            Integer.parseInt(csvReader.nextToken()),
                            csvReader.nextToken(),
                            csvReader.nextToken());
                } else {
                    System.err.println("Unrecognized type : \"" + type + "\".");
                    continue;
                }
            } catch (IllegalArgumentException iae) {
                printException(iae);
            }
            
            try {
                library.addItem(item);
            } catch (DuplicateException | NullPointerException ex) {
                printException(ex);
            }
        }
    }
    
    /**
     * @param ex the exception to be printed.
     */
    private static void printException(Exception ex) {
        System.err.println(ex.getClass().getName() + " : " + ex.getLocalizedMessage());
    }
}
