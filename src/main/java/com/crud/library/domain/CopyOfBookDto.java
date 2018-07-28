package com.crud.library.domain;

public class CopyOfBookDto {
    private int idCopy;
    private BookDto bookDto;
    private String status;

    public CopyOfBookDto() {
    }

    public CopyOfBookDto(int id, BookDto bookDto, String status) {
        this.idCopy = id;
        this.bookDto = bookDto;
        this.status = status;
    }

    public int getId() {
        return idCopy;
    }

    public BookDto getBook() {
        return bookDto;
    }

    public String getStatus() {
        return status;
    }
}
