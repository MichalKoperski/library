package com.crud.library.domain;

public class BookDto {
    private int idBook;
    private String title;
    private String author;
    private int publicationYear;

    public BookDto() {
    }

    public BookDto(int id, String title, String author, int publicationYear) {
        this.idBook = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public int getId() {
        return idBook;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}
