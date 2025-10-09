package bookstore.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;

//import bookstore.bookstore.domain.AppUser;
//import bookstore.bookstore.domain.AppUserRepository;
//import bookstore.bookstore.domain.Book;
//import bookstore.bookstore.domain.BookRepository;
//import bookstore.bookstore.domain.Category;
//import bookstore.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	// bean tekee sovelluksen käynnistyessä testidataa
	/*
	 * @Bean
	 * public CommandLineRunner demo(BookRepository bookRepository,
	 * CategoryRepository categoryRepository,
	 * AppUserRepository appUserRepository) {
	 * return (args) -> {
	 * log.info("save a couple of books");
	 * // lisätään kategorioita
	 * categoryRepository.save(new Category("Dokkari"));
	 * categoryRepository.save(new Category("Scifi"));
	 * // lisätään kirjoja
	 * Book book1 = new Book("Opi Spring Boottia", "Pelle Hermanni", 2022, 12134567,
	 * 29);
	 * Book book2 = new Book("Opi Spring Boottia, osa 2", "Pelle Hermanni", 2022,
	 * 12134567, 29);
	 * Book book3 = new Book("Opi taitavaksi Javaajaksi", "Kalle Ankka", 2018,
	 * 12134654, 14);
	 * Book book4 = new Book("Opi taitavaksi Javaajaksi2", "Kalle Ankka", 2020,
	 * 12134258, 16,
	 * categoryRepository.findByName("Dokkari").get(0));
	 * bookRepository.save(new Book("Koodailun iloa", "Kalle Hirvi", 2014, 12134645,
	 * 19,
	 * categoryRepository.findByName("Scifi").get(0)));
	 * 
	 * // tallenna kirjat 1-4 (h2)-tietokantaan
	 * bookRepository.save(book1);
	 * bookRepository.save(book2);
	 * bookRepository.save(book3);
	 * bookRepository.save(book4);
	 * 
	 * 
	 * 
	 * // luo käyttäjät admin/admin ja user/user
	 * AppUser user1 = new AppUser("user",
	 * "$2a$10$cKAXCXi3GdELDkJXkVbyZejKsnVP54lto0.MLzbvHYjGIoErpkGWO", "USER");
	 * AppUser user2 = new AppUser("admin",
	 * "$2a$10$R.ntvNy3FSQEgXLsNJh5xumIPlabSrtdBRMIzZAv8A0K.P.966VWW",
	 * "ADMIN");
	 * appUserRepository.save(user1);
	 * appUserRepository.save(user2);
	 * 
	 * for (Book book : bookRepository.findAll()) {
	 * log.info(book.toString());
	 * }
	 * 
	 * log.info("fetch all app users");
	 * for (AppUser user : appUserRepository.findAll()) {
	 * log.info("KÄYTTÄJÄ: " + user.toString());
	 * }
	 * 
	 * 
	 * };
	 * }
	 * 
	 */

}
