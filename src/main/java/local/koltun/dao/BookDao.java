package local.koltun.dao;

import local.koltun.domain.Book;

import java.util.List;

public interface BookDao {
    public void addBook(Book book);
    public void updateBook(Book book);
    public List<Book> listBooks();
    public Book getBookById(Integer id);
    public void removeBook(Integer id);
}
