package com.library.service;

import com.library.repository.BookRepository;

public class BookService {
    
    // The dependency to be injected
    private BookRepository bookRepository;

    // Setter method for Spring Dependency Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // A simple method to test if injection was successful
    public void manageBooks() {
        if (bookRepository != null) {
            System.out.println("Dependency Injection successful! BookRepository is wired into BookService.");
        } else {
            System.out.println("Dependency Injection failed!");
        }
    }
}