package designpatterns.dao;

import java.util.Collection;

/**
 *
 * @author Migue
 */
public interface BookDao {

    public Collection<Book> findAllBooks();
    public Book findBook(String isbn);
    public void save(Book book);
    public void update(Book book);
    public void delete(Book book);
    
}
