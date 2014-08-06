package system;

/**
 * The Magazine class.
 * @author Joris Schelfaut
 */
public class Magazine extends Periodical {

    private String topic;
    
    public Magazine(String title, String author, int year, Rating rating,
            String issn, int number, String series, String topic)
            throws IllegalArgumentException {
        super(title, author, year, rating, issn, number, series);
        this.setTopic(topic);
    }

    /**
     * @param topic the general topic of the magazine.
     */
    private void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * @return the general topic of the magazine.
     */
    public String getTopic() {
        return topic;
    }
}
