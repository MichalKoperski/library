package com.crud.library.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity(name="CUSTOMER")
public class Customer {
    private int idCustomer;
    private String firstname;
    private String lastname;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfJoin;
    private Rent rent;

    public Customer(){}

    public Customer(int idCustomer, String firstname, String lastname, LocalDate dateOfJoin) {
        this.idCustomer = idCustomer;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfJoin = dateOfJoin;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "IDCUSTOMER", unique = true)
    public int getId() {
        return idCustomer;
    }
    @Column(name = "FIRSTNAME")
    public String getFirstname() {
        return firstname;
    }
    @Column(name = "LASTNAME")
    public String getLastname() {
        return lastname;
    }
    @Column(name = "DATEOFJOIN")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public LocalDate getDateOfJoin() {
        return dateOfJoin;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="IDCUSTOMER")
    public Rent getRent() {return rent;}

    public void setId(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setDateOfJoin(LocalDate dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    public void setRent(Rent rent) {
        this.rent = rent;
    }
}
