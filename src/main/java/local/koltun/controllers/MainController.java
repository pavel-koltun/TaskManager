package local.koltun.controllers;

import local.koltun.domain.Book;
import local.koltun.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

public class MainController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/")
    public String index() {
        return "redirect:index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String mainPage(Map<String, Object> map) {
        map.put("books", bookService.listBooks());

        return "books";
    }

    @RequestMapping(value = "/show/{bookId}", method = RequestMethod.GET)
    public String bookPage(@PathVariable("bookId") Integer bookId, Map<String, Object> map) {
        Object book = bookService.getBookById(bookId);

        if (book == null) {
            return "redirect:/index";
        }

        map.put("book", bookService.getBookById(bookId));
        return "book";
    }

    @RequestMapping(value = "/remove/{bookId}")
    public String removeBook(@PathVariable("bookId") Integer id) {
        bookService.removeBook(id);

        return "redirect:/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book) {
        bookService.addBook(book);
        return "redirect:/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addBookPage(Map<String, Object> map) {
        map.put("book", new Book());
        return "add";
    }
}
