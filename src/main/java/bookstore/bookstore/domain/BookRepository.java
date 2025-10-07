package bookstore.bookstore.domain;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import java.util.List;


public interface BookRepository extends JpaRepository <Book, Long> {
    List<Book> findByTitle(String title);

}

