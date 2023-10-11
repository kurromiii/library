package com.mft.model.bl;

import com.mft.model.da.BookDA;
import com.mft.model.entity.Book;

public class BookBl {
    public static void add(Book book) throws Exception{
        try (BookDA bookDA = new BookDA()){
            bookDA.add(book);
        }
    }
    public static void update(Book book) throws Exception{
        try (BookDA bookDA = new BookDA()){
            bookDA.update(book);
        }
    }
    public static void remove(int id) throws Exception{
        try (BookDA bookDA = new BookDA()){
            bookDA.remove(id);
        }
    }
    public static void findAll() throws Exception{
        try (BookDA bookDA = new BookDA()){
            bookDA.findAll();
        }
    }
    public static void findAllByNameOrWriter(String name,String writer,boolean match) throws Exception{
        try (BookDA bookDA = new BookDA()){
            bookDA.findAllByNameOrWriter(name,writer,match);
        }
    }
    public static void findAvailableByName(String name) throws Exception{
        try (BookDA bookDA = new BookDA()){
            bookDA.findAvailableByName(name);
        }
    }
    public static void findById(int id) throws Exception{
        try (BookDA bookDA = new BookDA()){
            bookDA.findById(id);
        }
    }
}
