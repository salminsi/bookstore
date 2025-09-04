package bookstore.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bookstore.bookstore.domain.BookRepository;

@Controller

public class BookController {

    private BookRepository bookRepository;

    // constructor injection
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/booklist")
    public String Booklist(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "booklist";
    }

    @GetMapping("/index")
    @ResponseBody
    public String returnMessage() {
        return "Bookstore";
    }

    @GetMapping("/test")
    public String testPage() {
        return "test";
    }

}
