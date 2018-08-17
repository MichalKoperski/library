package com.crud.library.controller;


import com.crud.library.domain.*;
import com.crud.library.mapper.LibraryMapper;
import com.crud.library.service.DbService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(LibraryController.class)
public class LibraryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LibraryMapper libraryMapper;

    @MockBean
    private DbService service;

    @Test
    public void shouldAddCustomer() throws Exception {
        //Given
        Customer customer1 = new Customer(1, "John", "King", LocalDate.of(2018,10,10));

        CustomerDto customerDto1 = new CustomerDto(1, "John", "King", LocalDate.of(2018,10,10));

        when(libraryMapper.maptToCustomer(customerDto1)).thenReturn(customer1);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(customerDto1);

        //When & Then
        mockMvc.perform(post("/v1/library/addCustomer")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent));
    }

    @Test
    public void shouldAddBook() throws Exception {
        //Given
        Book book1 = new Book(1, "Title", "John", 2018);

        BookDto bookDto1 = new BookDto(1, "Title", "John", 2018);

        when(libraryMapper.maptToBook(bookDto1)).thenReturn(book1);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(bookDto1);

        //When & Then
        mockMvc.perform(post("/v1/library/addBook")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent));
    }

    @Test
    public void shouldAddCopyOfBook() throws Exception {
        //Given
        Book book1 = new Book(1, "Title", "John", 2018);
        CopyOfBook copy1 = new CopyOfBook(1, book1, "available");

        BookDto bookDto1 = new BookDto(1, "Title", "John", 2018);
        CopyOfBookDto copyDto1 = new CopyOfBookDto(1, bookDto1, "available");

        when(libraryMapper.maptToCopyOfBook(copyDto1)).thenReturn(copy1);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(copyDto1);

        //When & Then
        mockMvc.perform(post("/v1/library/addCopyOfBook")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent));
    }

    @Test
    public void shouldChangeStatus() throws Exception {
        //Given
        Book book1 = new Book(1, "Title", "John", 2018);
        CopyOfBook copy1 = new CopyOfBook(1, book1, "available");

        BookDto bookDto1 = new BookDto(1, "Title", "John", 2018);
        CopyOfBookDto copyDto1 = new CopyOfBookDto(1, bookDto1, "available");

        when(libraryMapper.maptToCopyOfBook(copyDto1)).thenReturn(copy1);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(copyDto1);

        //When & Then
        mockMvc.perform(put("/v1/library/changeCopyStatus")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent));
    }
    @Test
    public void shouldFindAvailableCopies() throws Exception {
        //Given
        Book book1 = new Book(1, "Title", "John", 2018);
        CopyOfBook copy1 = new CopyOfBook(1, book1, "AVAILABLE");

        BookDto bookDto1 = new BookDto(1, "Title", "John", 2018);
        CopyOfBookDto copyDto1 = new CopyOfBookDto(1, bookDto1, "AVAILABLE");

        when(service.availableCopies(libraryMapper.maptToBook(bookDto1))).thenReturn(1L);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(1L);

        //When & Then
        mockMvc.perform(get("/v1/library/availableCopies")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent));
    }
    @Test
    public void shouldRentBook() throws Exception {
        //Given
        Book book1 = new Book(1, "Title", "John", 2018);
        CopyOfBook copy1 = new CopyOfBook(1, book1, "available");

        BookDto bookDto1 = new BookDto(1, "Title", "John", 2018);
        CopyOfBookDto copyDto1 = new CopyOfBookDto(1, bookDto1, "available");

        Customer customer1 = new Customer(1, "John", "King", LocalDate.of(2018,10,10));
        CustomerDto customerDto1 = new CustomerDto(1, "John", "King", LocalDate.of(2018,10,10));

        RentDto rentDto1 = new RentDto(1, copyDto1, customerDto1, LocalDate.of(2018,10,10), LocalDate.of(2018,10,10));

        when(libraryMapper.maptToRentDto(service.rentBook(libraryMapper.maptToRent(rentDto1)))).thenReturn(rentDto1);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(rentDto1);

        //When & Then
        mockMvc.perform(post("/v1/library/rentBook")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent));
    }
    @Test
    public void shouldReturnBook() throws Exception {
        //Given
        Book book1 = new Book(1, "Title", "John", 2018);
        CopyOfBook copy1 = new CopyOfBook(1, book1, "available");

        BookDto bookDto1 = new BookDto(1, "Title", "John", 2018);
        CopyOfBookDto copyDto1 = new CopyOfBookDto(1, bookDto1, "available");

        Customer customer1 = new Customer(1, "John", "King", LocalDate.of(2018,10,10));
        CustomerDto customerDto1 = new CustomerDto(1, "John", "King", LocalDate.of(2018,10,10));

        Rent rent1 = new Rent(1, copy1, customer1, LocalDate.of(2018,10,10), LocalDate.of(2018,10,10));
        RentDto rentDto1 = new RentDto(1, copyDto1, customerDto1, LocalDate.of(2018,10,10), LocalDate.of(2018,10,10));

        when(libraryMapper.maptToRent(rentDto1)).thenReturn(rent1);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(rentDto1);

        //When & Then
        mockMvc.perform(post("/v1/library/bookReturn")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent));
    }
}
