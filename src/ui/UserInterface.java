package ui;

import system.Library;

/**
 * The UserInterface class; this class takes as argument a Library object,
 * whose public interface functions as an abstraction over the Library
 * functionality. A user interface provides an interaction platform for the
 * external user.
 * 
 * @author Joris Schelfaut
 */
public abstract class UserInterface {
    
    private Library library;
    
    /**
     * @param library the library that can be accessed through this view.
     */
    protected UserInterface(Library library) {
        super();
        this.setLibrary(library);
    }
    
    /**
     * @param   library the library that can be accessed through this user
     *          interface.
     * @throws  NullPointerException
     */
    private void setLibrary(Library library) throws NullPointerException {
        if (library == null) throw new NullPointerException(
                "The Library object resolved as NULL");
        this.library = library;
    }

    /**
     * @return the library that can be accessed through this user interface.
     */
    Library getLibrary() {
        return library;
    }
    
    /**
     * Starts the user interface.
     */
    public abstract void show();
       
    /**
     * @param ex the exception to be printed.
     */
    protected void printException(Exception ex) {
        System.err.println(ex.getClass().getName() + " : " + ex.getLocalizedMessage());
    }
}