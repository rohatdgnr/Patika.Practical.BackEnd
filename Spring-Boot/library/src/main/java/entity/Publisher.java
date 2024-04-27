package entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id",columnDefinition = "serial")
    private long id;

    @Column(name = "publisher_name",nullable = false)
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "publisher_build_year",nullable = false)
    private LocalDate year;

    @Column(name = "publisher_address",nullable = false)
    private String address;

    @OneToMany(mappedBy = "publisher",cascade = CascadeType.REMOVE)
    private List<Book> bookList;

    public Publisher() {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}
