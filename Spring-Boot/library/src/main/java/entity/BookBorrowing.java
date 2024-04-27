package entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "borrowings")
public class BookBorrowing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_id",columnDefinition = "serial")
    private long id;

    @Column(name = "borrow_name",nullable = false)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "borrow_date",nullable = false)
    private LocalDate date;

    @Temporal(TemporalType.DATE)
    @Column(name = "borrow_re_date",nullable = false)
    private LocalDate reDate;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "borrow_book_id",referencedColumnName = "book_id")
    private Book book;

    public BookBorrowing() {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getReDate() {
        return reDate;
    }

    public void setReDate(LocalDate reDate) {
        this.reDate = reDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}

