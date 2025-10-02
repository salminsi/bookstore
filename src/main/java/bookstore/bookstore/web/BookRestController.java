package bookstore.bookstore.web;

import org.springframework.web.bind.annotation.RestController;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;
import bookstore.bookstore.domain.CategoryRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController

public class BookRestController {

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    public BookRestController (BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

    //return list of books
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> GetBookById(@PathVariable Long id) {
        return bookRepository.findById(id);
    }

    //restin kautta yhden kirjan lisäys
    @PostMapping("/books")
    public Book saveBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    //restin kautta kirjan editointi EI TOIMI:

//    @GetMapping("/edit/{id}")
//    public Optional<Book> editBookById(@PathVariable Long id) {
//        return bookRepository.findById(id);
//    }


    //restin kautta kirjan poisto EI TOIMI:


 //   @GetMapping("/delete/{id}")
 //   public Optional<Book>deleteBook(@PathVariable Long id) {
 //       return bookRepository.findById(id);
 //   }
    
    

}
