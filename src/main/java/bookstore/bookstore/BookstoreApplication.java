package bookstore.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import bookstore.bookstore.domain.Book;
import bookstore.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {

	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	//bean tekee sovelluksen käynnistyessä testidataa
	@Bean
	public CommandLineRunner demo(BookRepository bookRepository) {
		return (args) -> {
			// lisätään kirjoja
			Book book1 = new Book("Opi Spring Boottia", "Pelle Hermanni", 2022, 12134567, 29);
			Book book2 = new Book("Opi Spring Boottia, osa 2", "Pelle Hermanni", 2022, 12134567, 29);
			Book book3 = new Book("Opi taitavaksi Javaajaksi", "Kalle Ankka", 2018, 12134654, 14);
			// tallenna kirjat (h2)-tietokantaan
			bookRepository.save(book1);
			bookRepository.save(book2);
			bookRepository.save(book3);

			for (Book book : bookRepository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
