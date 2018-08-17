package com.crud.library.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

public class CustomerDto {
    private int id;
    private String firstname;
    private String lastname;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfJoin;

    public CustomerDto(){}

    public CustomerDto(int id, String firstname, String lastname, LocalDate dateOfJoin) {
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

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public LocalDate getDateOfJoin() {
        return dateOfJoin;
    }

    public void setId(int id) {
        this.id = id;
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
}
