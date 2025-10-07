package bookstore.bookstore;


import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;
//import bookstore.bookstore.domain.Category;
import bookstore.bookstore.domain.CategoryRepository;


@DataJpaTest  //kun käytetään h2
//@SpringBootTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // if you are using real db tämä varmistaa
                                                                         // ettei tee pysyviä muutoksia tietokantaan
public class BookRepositoryTest {

    // in test cases field injection can be used
    @Autowired
    BookRepository bookRepository;

    @Autowired
    CategoryRepository categoryRepository;

    /* 
    @Test
    public void contexLoads() throws Exception {
      assertThat(controller).isNotNull();
    }
      */

    @Test
    public void findByTitleShouldReturnAuthor() {
        List<Book> books = bookRepository.findByTitle("Opi taitavaksi Javaajaksi");
        //assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Kalle Ankka");
    }

      
    @Test
    public void createNewBook() {
        Book book5 = new Book("A Head Full of Java", "Iines Ankka", 2015, 32, 43434564,
        categoryRepository.findByName("Dokkari").get(0)); 
        bookRepository.save(book5);
        assertThat(book5.getId()).isNotNull();
    }




@Test
public void deleteBook() {
    List<Book> books = bookRepository.findByTitle("Opi taitavaksi Javaajaksi2");
    Book book = books.get(0);
    bookRepository.delete(book);
    List<Book> newBooks = bookRepository.findByTitle("Opi taitavaksi Javaajaksi2");
    assertThat(newBooks).hasSize(0);

}

}
        



