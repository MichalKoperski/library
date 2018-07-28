package com.crud.library.mapper;

import com.crud.library.domain.*;
import org.springframework.stereotype.Component;

@Component
public class LibraryMapper {
    public Book maptToBook(BookDto bookDto) {
        return new Book(
                bookDto.getId(),
                bookDto.getTitle(),
                bookDto.getAuthor(),
                bookDto.getPublicationYear());
    }
    public BookDto maptToBookDto(Book book) {
        return new BookDto(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getPublicationYear());
    }
    public Customer maptToCustomer(CustomerDto customerDto) {
        return new Customer(
                customerDto.getId(),
                customerDto.getFirstname(),
                customerDto.getLastname(),
                customerDto.getDateOfJoin());
    }
    public CustomerDto maptToCustomerDto(Customer customer) {
        return new CustomerDto(
                customer.getId(),
                customer.getFirstname(),
                customer.getLastname(),
                customer.getDateOfJoin());
    }
    public CopyOfBook maptToCopyOfBook(CopyOfBookDto copyOfBookDto) {
        return new CopyOfBook(
                copyOfBookDto.getId(),
                maptToBook(copyOfBookDto.getBook()),
                copyOfBookDto.getStatus());
    }
    public CopyOfBookDto maptToCopyOfBookDto(CopyOfBook copyOfBook) {
        return new CopyOfBookDto(
                copyOfBook.getId(),
                maptToBookDto(copyOfBook.getBook()),
                copyOfBook.getStatus());
    }
    public Rent maptToRent(RentDto rentDto) {
        return new Rent(
                rentDto.getId(),
                maptToCopyOfBook(rentDto.getCopyOfBook()),
                maptToCustomer(rentDto.getCustomer()),
                rentDto.getDateOfRent(),
                rentDto.getRentTill());
    }
    public RentDto maptToRentDto(Rent rent) {
        return new RentDto(
                rent.getId(),
                maptToCopyOfBookDto(rent.getCopyOfBook()),
                maptToCustomerDto(rent.getCustomer()),
                rent.getDateOfRent(),
                rent.getRentTill());
    }
}
