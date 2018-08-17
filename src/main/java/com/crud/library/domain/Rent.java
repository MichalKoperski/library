package com.crud.library.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity(name="RENT")
public class Rent {
    private int idRent;
    private CopyOfBook copyOfBook;
    private Customer customer;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfRent;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate rentTill;

    public Rent() {
    }

    public Rent(int idRent, CopyOfBook copyOfBook, Customer customer, LocalDate dateOfRent, LocalDate rentTill) {
        this.idRent = idRent;
        this.copyOfBook = copyOfBook;
        this.customer = customer;
        this.dateOfRent = dateOfRent;
        this.rentTill = rentTill;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "IDRENT", unique = true)
    public int getId() {
        return idRent;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="IDCOPY")
    public CopyOfBook getCopyOfBook() {return copyOfBook;}

    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="IDCUSTOMER")
    public Customer getCustomer() { return customer;}

    @Column(name = "DATEOFRENT")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public LocalDate getDateOfRent() {
        return dateOfRent;
    }

    @Column(name = "RENTTILL")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public LocalDate getRentTill() {
        return rentTill;
    }

    public void setId(int idRent) {
        this.idRent = idRent;
    }

    public void setCopyOfBook(CopyOfBook copyOfBook) {
        this.copyOfBook = copyOfBook;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setDateOfRent(LocalDate dateOfRent) {
        this.dateOfRent = dateOfRent;
    }

    public void setRentTill(LocalDate rentTill) {
        this.rentTill = rentTill;
    }
}
