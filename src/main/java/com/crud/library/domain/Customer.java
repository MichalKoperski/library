package com.crud.library.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name="CUSTOMER")
public class Customer {
    private int idCustomer;
    private String firstname;
    private String lastname;
    private String dateOfJoin;

    public Customer(){}

    public Customer(int idCustomer, String firstname, String lastname, String dateOfJoin) {
        this.idCustomer = idCustomer;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfJoin = dateOfJoin;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID", unique = true)
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
    public String getDateOfJoin() {
        return dateOfJoin;
    }
    @OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name="IDCUSTOMER")
    public Rent getRentInfo() {return new Rent();}

    public void setId(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setDateOfJoin(String dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }
}
