package com.crud.library.domain;

public class RentDto {
    private int idRent;
    private CopyOfBookDto copyOfBookDto;
    private CustomerDto customerDto;
    private String dateOfRent;
    private String rentTill;

    public RentDto() {
    }

    public RentDto(int idRent, CopyOfBookDto copyOfBookDto, CustomerDto customerDto, String dateOfRent, String rentTill) {
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

    public String getDateOfRent() {
        return dateOfRent;
    }

    public String getRentTill() {
        return rentTill;
    }
}
