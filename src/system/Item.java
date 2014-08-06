package system;

/**
 * An item has a title, author, a unique code, publishing year,
 * rating, and type.
 * 
 * @author Joris Schelfaut
 */
public abstract class Item {
    
    private String title;
    private String author;
    private int year;
    private Rating rating;
    
    /**
     * Instantiates a new item.
     * @param title the title of the item.
     * @param author the author of the item.
     * @param year the publishing year of the item.
     * @param rating the rating of the item.
     * @throws IllegalArgumentException
     */
    public Item(String title, String author, int year, Rating rating)
            throws IllegalArgumentException {
        super();
        this.setAuthor(author);
        this.setRating(rating);
        this.setTitle(title);
        this.setYear(year);
    }
    
    /**
     * Instantiates a new item.
     * @param title the title of the item.
     * @param author the author of the item.
     * @param year the publishing year of the item.
     * @throws IllegalArgumentException
     */
    public Item(String title, String author, int year) 
            throws IllegalArgumentException {
        this(title, author, year, Rating.UNKNOWN);
    }

    /**
     * @param author the author of the item.
     * @throws IllegalArgumentException 
     */
    private void setAuthor(String author) throws IllegalArgumentException {
        if (author.isEmpty())
            throw new IllegalArgumentException("The length of the author"
                    + " name must be greater than zero.");
        this.author = author;
    }

    /**
     * @param rating the rating of the item.
     */
    private void setRating(Rating rating) {
        this.rating = rating;
    }

    /**
     * @param title the title of the item.
     * @throws IllegalArgumentException 
     */
    private void setTitle(String title) throws IllegalArgumentException {
        if (title.isEmpty())
            throw new IllegalArgumentException("The length of the title"
                    + " must be greater than zero.");
        this.title = title;
    }

    /**
     * @param year the publishing year of the item.
     */
    private void setYear(int year) {
        this.year = year;
    }
    
    /**
     * @return the author of this item.
     */
    public String getAuthor() {
        return this.author;
    }
    
    /**
     * @return the rating of this item.
     */
    public Rating getRating() {
        return this.rating;
    }
    
    /**
     * @return the title of this item.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * @return the publishing year of this item.
     */
    public int getYear() {
        return this.year;
    }
    
    /**
     * @return the unique code of this item.
     */
    public abstract String getCode();

    @Override
    public String toString() {
        return this.getAuthor() + ", " + this.getYear()
                + ", \"" + this.getTitle() + "\"";
    }

    @Override
    public int hashCode() {
        return this.getCode().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj instanceof Item) {
            Item i = (Item) obj;
            if (! this.getCode().equals(i.getCode()))
                return false;
        }
        return true;
    }
}
