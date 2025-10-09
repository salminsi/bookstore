package bookstore.bookstore.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="book")

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @NotEmpty(message = "Book's title cannot be empty.")
    @Size(min = 1, max = 250)
    @Column(name = "title", nullable = false)
    private String title;

    @NotEmpty(message = "Book's author cannot be empty.")
    @Size(min = 1, max = 250)
    @Column(name = "author", nullable = false)
    private String author;

    @Min(value = 0, message = "Publishing year cannot be negative or null.")
    @Column(name = "publicationyear", nullable = false)
    private int publicationYear;

    @ManyToOne
    @JoinColumn(name = "categoryid") // categoryid tulee tietokannasta (fk)
    private Category kategoria;

    @Column(name = "isbn", nullable = false)
    private int isbn;
    
    @Column(name = "price", nullable = false)
    private int price;

    public Book() {
    }

    public Book(String title, String author, int publicationYear, int isbn, int price) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
    }

    public Book(Category kategoria) {
        this.kategoria = kategoria;
    }

    public Book(@NotEmpty(message = "Book's title cannot be empty.") @Size(min = 1, max = 250) String title,
            @NotEmpty(message = "Book's author cannot be empty.") @Size(min = 1, max = 250) String author,
            @Min(value = 0, message = "Publishing year cannot be negative or null.") int publicationYear, int isbn, int price, Category kategoria) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isbn = isbn;
        this.price = price;
        this.kategoria = kategoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.kategoria = category;
    }

    

    public Category getKategoria() {
        return kategoria;
    }

    public void setKategoria(Category kategoria) {
        this.kategoria = kategoria;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publicationYear=" + publicationYear
                + ", kategoria=" + kategoria + ", isbn=" + isbn + ", price=" + price + "]";
    }

    

}
