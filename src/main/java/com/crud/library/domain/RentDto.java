package com.crud.library.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

public class RentDto {
    private int idRent;
    private CopyOfBookDto copyOfBookDto;
    private CustomerDto customerDto;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate dateOfRent;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate rentTill;

    public RentDto() {
    }

    public RentDto(int idRent, CopyOfBookDto copyOfBookDto, CustomerDto customerDto, LocalDate dateOfRent, LocalDate rentTill) {
        this.idRent = idRent;
        this.copyOfBookDto = copyOfBookDto;
        this.customerDto = customerDto;
        this.dateOfRent = dateOfRent;
        this.rentTill = rentTill;
    }

    public int getId() {
        return idRent;
    }

    public CopyOfBookDto getCopyOfBook() {
        return copyOfBookDto;
    }

    public CustomerDto getCustomer() {
        return customerDto;
    }

    public LocalDate getDateOfRent() {
        return dateOfRent;
    }

    public LocalDate getRentTill() {
        return rentTill;
    }

    public void setId(int idRent) {
        this.idRent = idRent;
    }

    public void setCopyOfBookDto(CopyOfBookDto copyOfBookDto) {
        this.copyOfBookDto = copyOfBookDto;
    }

    public void setCustomerDto(CustomerDto customerDto) {
        this.customerDto = customerDto;
    }

    public void setDateOfRent(LocalDate dateOfRent) {
        this.dateOfRent = dateOfRent;
    }

    public void setRentTill(LocalDate rentTill) {
        this.rentTill = rentTill;
    }
}
