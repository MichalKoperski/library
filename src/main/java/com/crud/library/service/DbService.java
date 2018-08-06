package com.crud.library.service;

import com.crud.library.domain.Book;
import com.crud.library.domain.CopyOfBook;
import com.crud.library.domain.Customer;
import com.crud.library.domain.Rent;
import com.crud.library.repository.BookRepository;
import com.crud.library.repository.CopyOfBookRepository;
import com.crud.library.repository.CustomerRepository;
import com.crud.library.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DbService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CopyOfBookRepository copyOfBookRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private RentRepository rentRepository;

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }
    public void addBook(Book book) {
        bookRepository.save(book);
    }
    public void addCopyOfBook(CopyOfBook copyOfBook) {
        copyOfBookRepository.save(copyOfBook);
    }
    public void changeCopyStatus(CopyOfBook copyOfBook, String status) {
        copyOfBook = new CopyOfBook(copyOfBook.getId(), copyOfBook.getBook(), status);
        copyOfBookRepository.save(copyOfBook);
    }
    public long availableCopies(Book book) {
       return copyOfBookRepository.findAll().stream()
                .filter(t-> t.getBook().getId()==book.getId())
                .filter(t->t.getStatus().equalsIgnoreCase("AVAILABLE"))
                .count();
    }
    public Rent rentBook(Rent rent) {
        return rentRepository.save(rent);
    }
    public void bookReturn(Rent rent) {
        rentRepository.deleteById(rent.getId());
    }
}
