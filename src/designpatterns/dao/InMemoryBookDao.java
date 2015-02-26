package designpatterns.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Migue
 */
public class InMemoryBookDao implements BookDao{
    
    private static final Map<String, Book> books = new HashMap<>();

    @Override
    public Collection<Book> findAllBooks() {
        return books.values();
    }

    @Override
    public Book findBook(String isbn) {
        return books.get(isbn);
    }

    @Override
    public void save(Book book) {
        books.put(book.getIsbn(), book);
    }

    @Override
    public void update(Book book) {
        //no operation for in memory database
    }

    @Override
    public void delete(Book book) {
        books.remove(book.getIsbn());
    }
}
