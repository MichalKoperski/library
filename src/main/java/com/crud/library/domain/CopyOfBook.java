package com.crud.library.domain;

import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name="COPYOFBOOK")
public class CopyOfBook {
    private int idCopy;
    private Book book;
    private String status;
    private Rent rent;

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
    @Column(name = "IDCOPY", unique = true)
    public int getId() {
        return idCopy;
    }

    @ManyToOne(
            targetEntity = Book.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name="IDBOOK")
    public Book getBook() {
        return book;
    }

    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="IDCOPY")
    public Rent getRent() {return rent;}

    public void setId(int idCopy) {
        this.idCopy = idCopy;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }
}
