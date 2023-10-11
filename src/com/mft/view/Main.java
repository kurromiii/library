package com.mft.view;

import com.mft.controller.BookController;
import com.mft.controller.BorrowController;
import com.mft.controller.PersonController;
import com.mft.model.da.BookDA;
import com.mft.model.da.BorrowDA;
import com.mft.model.da.PersonDA;
import com.mft.model.entity.Book;
import com.mft.model.entity.Borrow;
import com.mft.model.entity.Person;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        //test add
//        PersonController.add("zahra","arasteh");
//        BookController.add("Hello kitty","Hitler",10);
//        BorrowController.add(30,23,LocalDateTime.now());

        //test update
//        PersonController.update(8,"Ali","Alipour");
//        BookController.update(1,"Attack on titan","Isayama",10);
//        BorrowController.update(29,1,LocalDateTime.now());

        //test remove
//        PersonController.remove(9);
//        BookController.remove(21);
//        BorrowController.remove(29);

        //test findAll
//        PersonController.findAll();
//        BookController.findAll();
//        BorrowController.findAll();

        //test find by name ...
//        PersonController.findAllByNameAndFamily("a","a",true);
//        BookController.findAllByNameOrWriter("Attack","Isayama",false);

        //find by id
//        PersonController.findById(8);
//        BookController.findById(5);
//        BookController.findAvailableByName("Attack on titan");
//       BookController.findAvailableByName("Math");





    }
}
