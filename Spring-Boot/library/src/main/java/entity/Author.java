package entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id", columnDefinition = "serial")
    private long id;

    @Column(name = "author_name", nullable = false)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "author_birthday", nullable = false)
    private LocalDate year;

    @Column(name = "author_country", nullable = false)
    private String country;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    private List<Book> bookList;

    public Author() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}