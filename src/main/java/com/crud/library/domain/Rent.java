package com.crud.library.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name="RENT")
public class Rent {
    private int idRent;
    private CopyOfBook copyOfBook;
    private Customer customer;
    private String dateOfRent;
    private String rentTill;

    public Rent() {
    }

    public Rent(int idRent, CopyOfBook copyOfBook, Customer customer, String dateOfRent, String rentTill) {
        this.idRent = idRent;
        this.copyOfBook = copyOfBook;
        this.customer = customer;
        this.dateOfRent = dateOfRent;
        this.rentTill = rentTill;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
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
    public String getDateOfRent() {
        return dateOfRent;
    }

    @Column(name = "RENTTILL")
    public String getRentTill() {
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

    public void setDateOfRent(String dateOfRent) {
        this.dateOfRent = dateOfRent;
    }

    public void setRentTill(String rentTill) {
        this.rentTill = rentTill;
    }
}
