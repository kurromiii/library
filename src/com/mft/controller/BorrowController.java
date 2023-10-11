package com.mft.controller;

import com.mft.controller.exceptions.ExceptionWrapper;
import com.mft.model.bl.BorrowBl;
import com.mft.model.entity.Borrow;
import com.mft.model.entity.BorrowView;

import java.time.LocalDateTime;

public class BorrowController {
    public static void add(int personId, int bookId, LocalDateTime borrowDate){
        if (personId != 0 & bookId != 0){
            Borrow borrow = new Borrow(personId,bookId,borrowDate);
            try {
                BorrowBl.add(borrow);
            } catch (Exception e) {
                ExceptionWrapper.getMassage(e);
            }
        }
    }
    public static void update(int personId, int bookId, LocalDateTime borrowDate){
        if (personId != 0 & bookId != 0){
            Borrow borrow = new Borrow(personId,bookId,borrowDate);
            try {
                BorrowBl.update(borrow);
            } catch (Exception e) {
                ExceptionWrapper.getMassage(e);
            }
        }
    }
    public static void remove(int personId){
        if (personId != 0){
            Borrow borrow = new Borrow(personId);
            try {
                BorrowBl.remove(personId);
            } catch (Exception e) {
                ExceptionWrapper.getMassage(e);
            }
        }
    }
    public static void findAll(){
        BorrowView borrowView = new BorrowView();
        try {
            BorrowBl.findAll();
        } catch (Exception e) {
            ExceptionWrapper.getMassage(e);
        }

    }
}
