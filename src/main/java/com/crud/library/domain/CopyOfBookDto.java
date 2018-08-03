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

    public void setId(int idCopy) {
        this.idCopy = idCopy;
    }

    public void setBookDto(BookDto bookDto) {
        this.bookDto = bookDto;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
