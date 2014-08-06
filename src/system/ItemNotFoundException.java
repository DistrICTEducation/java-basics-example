package system;

/**
 * @author Joris Schelfaut
 */
public class ItemNotFoundException extends RuntimeException {

    /**
     * Instantiates a new ItemNotFoundException object.
     * @param code 
     */
    public ItemNotFoundException(String code) {
        super("The item with code " + code + " could not be"
                + " found in the library.");
    }    
}
