package designpatterns.dao;

import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author Migue
 */
public class DataBaseBookDao implements BookDao{

    @Override
    public Collection<Book> findAllBooks() {
        System.out.println("Finds all books");
        return new HashMap().values();
    }

    @Override
    public Book findBook(String isbn) {
        return new Book("000", "Test book", "Test author");
    }

    @Override
    public void save(Book book) {
        
    }

    @Override
    public void update(Book book) {
        
    }

    @Override
    public void delete(Book book) {
        
    }
    
}
