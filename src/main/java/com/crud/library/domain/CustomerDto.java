package com.crud.library.domain;

public class CustomerDto {
    private int id;
    private String firstname;
    private String lastname;
    private String dateOfJoin;

    public CustomerDto(){}

    public CustomerDto(int id, String firstname, String lastname, String dateOfJoin) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateOfJoin = dateOfJoin;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getDateOfJoin() {
        return dateOfJoin;
    }
}