package system;

/**
 * The Book class is an item with ISBN number.
 * @author Joris Schelfaut
 */
public class Book extends Item {

    private String isbn;
    
    /**
     * Instantiates a new Book object.
     * @param title
     * @param author
     * @param year
     * @param rating
     * @param isbn 
     */
    public Book(String title, String author, int year,
            Rating rating, String isbn) {
        super(title, author, year, rating);
        this.setISBN(isbn);
    }
    
    /**
     * @param isbn the ISBN to be set.
     */
    private void setISBN(String isbn) throws IllegalArgumentException {
        if (! correctISBNFormat(isbn))
            throw new IllegalArgumentException("The ISBN did not have the correct format.");
        this.isbn = isbn;
    }
    
    /**
     * The ISBN is of one the following formats :
     * <ul>
     *      <li>0123456789</li>
     *      <li>123-0123456789</li>
     * </ul>
     * @param isbn the ISBN to be checked.
     * @return whether or not the ISBN value has the correct format.
     */
    public static boolean correctISBNFormat(String isbn) {
        String regex = "\\d+";
        if (isbn.length() == 10) return isbn.matches(regex);
        
        if (isbn.length() == 14) {
            String i[] = isbn.split("\\-");
            if (i[0].length() != 3) return false;
            return i[0].matches(regex) && correctISBNFormat(i[1]);
        }
        
        return false;
    }
    
    @Override
    public String getCode() {
        return isbn;
    }
    
}
