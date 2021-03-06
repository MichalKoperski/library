package com.crud.library.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name="BOOK")
public class Book {
    private int idBook;
    private String title;
    private String author;
    private int publicationYear;
    private List<CopyOfBook> listOfCopies = new ArrayList<>();

    public Book() {
    }

    public Book(int idBook, String title, String author, int publicationYear) {
        this.idBook = idBook;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "IDBOOK", unique = true)
    public int getId() {
        return idBook;
    }

    @Column(name = "TITLE")
    public String getTitle() {
        return title;
    }

    @Column(name="AUTHOR")
    public String getAuthor() {
        return author;
    }

    @Column(name="PUBLICATIONYEAR")
    public int getPublicationYear() {
        return publicationYear;
    }

    @OneToMany(
            targetEntity = CopyOfBook.class,
            mappedBy = "book",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    // @JoinColumn(name="IDBOOK")
    public List<CopyOfBook> getListOfCopies() {
        return listOfCopies;
    }
    public void setId(int idBook) {
        this.idBook = idBook;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setListOfCopies(List<CopyOfBook> listOfCopies) {this.listOfCopies = listOfCopies;}
}
