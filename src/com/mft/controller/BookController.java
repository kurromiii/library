package com.mft.controller;

import com.mft.controller.exceptions.ExceptionWrapper;
import com.mft.model.bl.BookBl;
import com.mft.model.bl.PersonBl;
import com.mft.model.entity.Book;
import com.mft.model.entity.Person;

public class BookController {
    public static void add(String name,String writer,int count){
        if (name != null & writer != null){
            Book book = new Book(name,writer,count);
            try {
                BookBl.add(book);
            } catch (Exception e) {
                ExceptionWrapper.getMassage(e);
            }
        }
    }
    public static void update(int id,String name,String writer,int count){
        if (name != null & writer != null){
            Book book = new Book(id,name,writer,count);
            try {
                BookBl.update(book);
            } catch (Exception e) {
                ExceptionWrapper.getMassage(e);
            }
        }
    }
    public static void remove(int id) {
        if (id != 0) {
            Book book = new Book(id);
            try {
                BookBl.remove(id);
            } catch (Exception e) {
                ExceptionWrapper.getMassage(e);
            }
        }
    }
    public static void findAll(){
        Book book = new Book();
        try {
            BookBl.findAll();
        } catch (Exception e) {
            ExceptionWrapper.getMassage(e);
        }
    }
    public static void findAllByNameOrWriter(String name,String writer,boolean match){
        if (name != null & writer != null) {
            Person person = new Person(name,writer);
        }
        try {
            BookBl.findAllByNameOrWriter(name,writer,match);
        } catch (Exception e) {
            ExceptionWrapper.getMassage(e);
        }
    }
    public static void findAvailableByName(String name){
        if (name != null) {
            Book book = new Book(name);
            try {
                BookBl.findAvailableByName(name);
            } catch (Exception e) {
                ExceptionWrapper.getMassage(e);
            }
        }
    }
    public static void findById(int id) {
        if (id != 0){
            Book book = new Book(id);
            try {
                BookBl.findById(id);
            } catch (Exception e) {
                ExceptionWrapper.getMassage(e);
            }
        }
    }


}
