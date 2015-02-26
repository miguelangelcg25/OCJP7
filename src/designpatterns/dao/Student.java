package designpatterns.dao;

/**
 *
 * @author Migue
 */
public class Student {

    public static void main(String[] args) {
        Util.setTestMode(true);
        BookDao bookDao = new FactoryImpl().getDao();
        Book book1 = new Book("001", "El diario de Ana Frank", "Ana Frank");
        Book book2 = new Book("002", "El señor de los anillos", "J. R. Tolkien");
        
        bookDao.save(book1);
        bookDao.save(book2);
        
        for(Book book: bookDao.findAllBooks()){
            System.out.println(book);
        }
    }
}
