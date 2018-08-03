package com.crud.library.domain;

import org.hibernate.engine.internal.Cascade;

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
    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="IDCOPY")
    public Rent getRentInfo() {return new Rent();}

    public void setId(int idCopy) {
        this.idCopy = idCopy;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
