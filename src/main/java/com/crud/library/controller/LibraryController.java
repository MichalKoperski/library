package com.crud.library.controller;

import com.crud.library.domain.*;
import com.crud.library.mapper.LibraryMapper;
import com.crud.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/library")
public class LibraryController {
    @Autowired
    private DbService service;
    @Autowired
    private LibraryMapper libraryMapper;
    @RequestMapping(method = RequestMethod.POST, value = "addCustomer")
    public void addCustomer(@RequestBody CustomerDto customerDto) {
        service.addCustomer(libraryMapper.maptToCustomer(customerDto));
    }
    @RequestMapping(method = RequestMethod.POST, value = "addBook")
    public void addBook(@RequestBody BookDto bookDto) {
        service.addBook(libraryMapper.maptToBook(bookDto));
    }
    @RequestMapping(method = RequestMethod.POST, value = "addCopyOfBook")
    public void addCopyOfBook(@RequestBody CopyOfBookDto copyOfBookDto) {
        service.addCopyOfBook(libraryMapper.maptToCopyOfBook(copyOfBookDto));
    }
    @RequestMapping(method = RequestMethod.PUT, value = "changeCopyStatus")
    public void changeCopyStatus(@RequestBody CopyOfBookDto copyOfBookDto, @RequestParam String status) {
        service.changeCopyStatus(libraryMapper.maptToCopyOfBook(copyOfBookDto), status);
    }
    @RequestMapping(method = RequestMethod.GET, value = "availableCopies")
    public long availableCopies(@RequestBody BookDto bookDto) {
        return service.availableCopies(libraryMapper.maptToBook(bookDto));
    }
    @RequestMapping(method = RequestMethod.POST, value = "rentBook")
    public RentDto rentBook(@RequestBody CopyOfBookDto copyOfBookDto, @RequestBody CustomerDto customerDto) {
        return libraryMapper.maptToRentDto(service.rentBook(libraryMapper.maptToCopyOfBook(copyOfBookDto),libraryMapper.maptToCustomer(customerDto)));
    }
    @RequestMapping(method = RequestMethod.POST, value = "bookReturn")
    public void bookReturn(@RequestBody RentDto rentDto) {
        service.bookReturn(libraryMapper.maptToRent(rentDto));
    }
}
