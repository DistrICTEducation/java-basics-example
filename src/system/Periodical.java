package system;

/**
 * The Periodical class is an item with ISSN number.
 * @author Joris Schelfaut
 */
public abstract class Periodical extends Item {

    private String issn;
    private int number;
    private String series;
    
    /**
     * Instantiates a new periodical object.
     * @param title
     * @param author
     * @param year
     * @param rating
     * @param issn 
     * @param number
     * @param series 
     */
    public Periodical(String title, String author, int year, Rating rating,
            String issn, int number, String series)
            throws IllegalArgumentException {
        super(title, author, year, rating);
        this.setISSN(issn);
        this.setNumber(number);
        this.setSeries(series);
    }

    /**
     * @param issn the ISSN number of the periodical.
     */
    private void setISSN(String issn) {
        this.issn = issn;
    }
    
    /**
     * @param series the name of the series of the periodical.
     */
    private void setSeries(String series) {
        this.series = series;
    }

    /**
     * @return the name of the series of the periodical.
     */
    public String getSeries() {
        return series;
    }
    
    /**
     * @param number the number of the periodical.
     * @throws IllegalArgumentException
     */
    private void setNumber(int number) throws IllegalArgumentException {
        if (number < 0)
            throw new IllegalArgumentException("The number must be positive.");
        this.number = number;
    }

    /**
     * @return the number of the periodical.
     */
    public int getNumber() {
        return number;
    }

    @Override
    public String getCode() {
        return issn;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", " + this.getSeries()
                + " #" + this.getNumber();
    }
}
