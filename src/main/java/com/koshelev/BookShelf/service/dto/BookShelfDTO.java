package com.koshelev.BookShelf.service.dto;


public class BookShelfDTO {
    private String name;


    public BookShelfDTO() {
    }

    public BookShelfDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
