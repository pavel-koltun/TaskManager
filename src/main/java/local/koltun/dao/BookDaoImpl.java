package local.koltun.dao;

import local.koltun.domain.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    @Override
    public void addBook(Book book) {
        sessionFactory.getCurrentSession().save(book);
    }

    @Transactional
    @Override
    public void updateBook(Book book) {
        sessionFactory.getCurrentSession().update(book);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Book> listBooks() {
        return sessionFactory.getCurrentSession().createQuery("from Book").list();
    }

    @Transactional(readOnly = true)
    @Override
    public Book getBookById(Integer id) {
        return (Book) sessionFactory.getCurrentSession().get(Book.class, id);
    }

    @Transactional
    @Override
    public void removeBook(Integer id) {
        Session session = sessionFactory.getCurrentSession();

        Book book = (Book) session.get(Book.class, id);

        if (book != null) {
            session.delete(book);
        }
    }
}
