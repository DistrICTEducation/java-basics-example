package system;

/**
 * The Comic class.
 * @author Joris Schelfaut
 */
public class Comic extends Periodical {
    
    /**
     * Instantiates a new Comic object.
     * @param title
     * @param author
     * @param year
     * @param rating
     * @param issn
     * @param number
     * @param series 
     */
    public Comic(String title, String author, int year, Rating rating,
            String issn, int number, String series) {
        super(title, author, year, rating, issn, number, series);
    }
}
