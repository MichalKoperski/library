package com.crud.library.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name="COPYOFBOOK")
public class CopyOfBook {
    private int idCopy;
    private Book book;
    private String status;

    public CopyOfBook() {
    }

    public CopyOfBook(int idCopy, Book book, String status) {
        this.idCopy = idCopy;
        this.book = book;
        this.status = status;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return idCopy;
    }

    @ManyToOne
    @JoinColumn(name="IDBOOK")
   // @Column(name = "BOOK")
    public Book getBook() {
        return book;
    }
    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }
    @OneToMany(
            targetEntity = Rent.class,
            mappedBy = "copyOfBook",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public Rent getRentInfo() {
        return new Rent();
    }
}
