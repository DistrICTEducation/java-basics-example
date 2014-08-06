package system;

/**
 * @author Joris Schelfaut
 */
public class DuplicateException extends RuntimeException {
    
    /**
     * Instantiates a new DuplicateException.
     * 
     * @param item 
     */
    public DuplicateException(Item item) {
        super("The item with title '" + item.getTitle()
            + "' is already in the library.");
    }    
}
