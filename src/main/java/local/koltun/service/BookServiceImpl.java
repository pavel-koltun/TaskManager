package local.koltun.service;

import local.koltun.dao.BookDao;
import local.koltun.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public List<Book> listBooks() {
        return bookDao.listBooks();
    }

    @Override
    public Book getBookById(Integer id) {
        return bookDao.getBookById(id);
    }

    @Override
    public void removeBook(Integer id) {
        bookDao.removeBook(id);
    }
}
