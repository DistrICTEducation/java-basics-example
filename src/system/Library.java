package system;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Library class manages a collection of items. Items can be added or
 * removed.
 * 
 * @author Joris Schelfaut
 */
public class Library {

    private final List<Item> items;
    
    /**
     * Instantiates a new Library object.
     */
    public Library() {
        super();
        items = new ArrayList<>();
    }
    
    /**
     * Adds the new item to the library.
     * @param item the item to be added.
     * @throws NullPointerException
     * @throws DuplicateException
     */
    public void addItem (Item item)
            throws NullPointerException, DuplicateException {
        if (item == null)
            throw new NullPointerException("The item resloved as NULL.");
        if (this.items.contains(item))
            throw new DuplicateException(item);
        this.items.add(item);
    }
    
    /**
     * Removes the item from the library.
     * @param item the item to be removed.
     */
    public void removeItem (Item item) {
        this.items.remove(item);
    }
    
    /**
     * Find an item in the library.
     * @param code
     * @return the item with corresponding code.
     * @throws ItemNotFoundException
     */
    public Item lookup (String code) throws ItemNotFoundException {
        for (Item i : this.items) {
            if (i.getCode().equals(code))
                return i;
        }
        throw new ItemNotFoundException(code);
    }
    
    /**
     * @return all periodicals in the library.
     */
    public Map<String, Periodical> getPeriodicals() {
        Map<String, Periodical> periodicals = new HashMap<>();
        for (Item i : this.items) {
            if (i instanceof Periodical) {
                Periodical p = (Periodical) i;
                periodicals.put(p.getSeries() + "#" + p.getNumber(), p);
            }
        }        
        return periodicals;
    }
    
    /**
     * @return all books in the library.
     */
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        for (Item i : this.items) {
            if (i instanceof Book) {
                books.add((Book) i);
            }
        }
        return books;
    }
    
    /**
     * @return the list of items.
     */
    public List<Item> getItems() {
        return Collections.unmodifiableList(this.items);
    }
}
