package bookstore.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;
//import jakarta.validation.Valid;

//orkesterinjohtaja
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

    /*
     * virheilmoitusten käsittelyyn:
     * 
     * @PostMapping("/newmessage")
     * public String greetingSubmit(@Valid Message message, BindingResult
     * bindingResult, Model model) {
     * if (bindingResult.hasErrors()) {
     * return "form"; // form.html
     * }
     * model.addAttribute("message", message);
     * return "result"; // result.html
     * }
     */

    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "addbook";
    }

    @PostMapping("/save")
    public String save(Book book) {
        bookRepository.save(book);
        return "redirect:/booklist";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
        return "redirect:/booklist";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("edit", bookRepository.findById(id));
        return "editbook";
    }

    /*
     * @PostMapping("/saveEditedBook")
     * public String saveEditedBook(@Valid @ModelAttribute("edit") Book book,
     * BindingResult bindingResult, Model model) {
     * log.info ("CONTROLLER: Save edited the book - check validation of book: " +
     * book);
     * 
     * if (bindingResult.hasErrors()) {
     * log.error("some validation error happened, book: " + book);
     * model.addAttribute("edit", book);
     * 
     * return "editbook";
     * }
     * log.info("save book: " + book);
     * bookRepository.save(book);
     * return "redirect:/booklist";
     * }
     */

    @PostMapping("/edit/save")
    public String saveEdited(Book book) {
        bookRepository.save(book);
        return "redirect:/booklist";
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
