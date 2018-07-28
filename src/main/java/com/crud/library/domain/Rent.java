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
    @ManyToOne
    @JoinColumn(name="IDCOPY")
    //@Column(name = "COPYOFBOOK")
    public CopyOfBook getCopyOfBook() {
        return copyOfBook;
    }
    @ManyToOne
    @JoinColumn(name="IDCUSTOMER")
    //@Column(name = "CUSTOMER")
    public Customer getCustomer() {
        return customer;
    }
    @Column(name = "DATEOFRENT")
    public String getDateOfRent() {
        return dateOfRent;
    }
    @Column(name = "RENTTILL")
    public String getRentTill() {
        return rentTill;
    }
}
