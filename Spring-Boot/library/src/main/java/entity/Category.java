package entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "categorys")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id",columnDefinition = "serial")
    private long id;

    @Column(name = "category_name",nullable = false)
    private String name;

    @Column(name = "category_description",nullable = false)
    private String description;

    @ManyToMany(mappedBy = "categories",cascade = CascadeType.REMOVE)
    private List<Book> bookList;
    public Category() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }
}

