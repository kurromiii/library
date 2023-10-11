package com.mft.model.entity;

import com.google.gson.Gson;

import java.time.LocalDateTime;

// create view borrow_view as
// select
// person.id as person_id,person.name as person_name,person.family as person_family,book.id as book_id,book.name as
// book_name,book.writer as book_writer,book.count as book_count,borrow.borrow_date
// from person,book,borrow
// where person.id = borrow.person_id
// and book.id = borrow.book_id;

public class BorrowView {
    private int personId;
    private String personName;
    private String personFamily;
    private int bookId;
    private String bookName;
    private String bookWriter;
    private int count;
    private LocalDateTime borrowTime;

    public BorrowView() {
    }

    public BorrowView(int personId, String personName, String personFamily, int bookId, String bookName, String bookWriter, int count, LocalDateTime borrowTime) {
        this.personId = personId;
        this.personName = personName;
        this.personFamily = personFamily;
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookWriter = bookWriter;
        this.count = count;
        this.borrowTime = borrowTime;
    }

    public int getPersonId() {
        return personId;
    }

    public BorrowView setPersonId(int personId) {
        this.personId = personId;
        return this;
    }

    public String getPersonName() {
        return personName;
    }

    public BorrowView setPersonName(String personName) {
        this.personName = personName;
        return this;
    }

    public String getPersonFamily() {
        return personFamily;
    }

    public BorrowView setPersonFamily(String personFamily) {
        this.personFamily = personFamily;
        return this;
    }

    public int getBookId() {
        return bookId;
    }

    public BorrowView setBookId(int bookId) {
        this.bookId = bookId;
        return this;
    }

    public String getBookName() {
        return bookName;
    }

    public BorrowView setBookName(String bookName) {
        this.bookName = bookName;
        return this;
    }

    public String getBookWriter() {
        return bookWriter;
    }

    public BorrowView setBookWriter(String bookWriter) {
        this.bookWriter = bookWriter;
        return this;
    }

    public int getCount() {
        return count;
    }

    public BorrowView setCount(int count) {
        this.count = count;
        return this;
    }

    public LocalDateTime getBorrowTime() {
        return borrowTime;
    }

    public BorrowView setBorrowTime(LocalDateTime borrowTime) {
        this.borrowTime = borrowTime;
        return this;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
