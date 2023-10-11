package com.mft.model.entity;

import com.google.gson.Gson;

import java.time.LocalDateTime;

// create table borrow (person_id references person, book_id references book, borrow_date timestamp);
public class Borrow {
    private int id;
    private int personId;
    private int bookId;
    private LocalDateTime borrowDate;

    public Borrow() {
    }

    public Borrow(int personId, int bookId, LocalDateTime borrowDate) {
        this.personId = personId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
    }

    public Borrow(int personId) {
        this.personId = personId;
    }

    public int getPersonId() {
        return personId;
    }

    public Borrow(int id, int personId, int bookId, LocalDateTime borrowDate) {
        this.id = id;
        this.personId = personId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
    }

    public int getId() {
        return id;
    }

    public Borrow setId(int id) {
        this.id = id;
        return this;
    }

    public Borrow setPersonId(int personId) {
        this.personId = personId;
        return this;
    }

    public int getBookId() {
        return bookId;
    }

    public Borrow setBookId(int bookId) {
        this.bookId = bookId;
        return this;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public Borrow setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
        return this;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
