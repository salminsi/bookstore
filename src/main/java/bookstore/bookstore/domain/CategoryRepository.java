package bookstore.bookstore.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findByName(String name);

}
