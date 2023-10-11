package com.mft.model.bl;

import com.mft.controller.exceptions.ExceptionWrapper;
import com.mft.model.da.BorrowDA;
import com.mft.model.da.BorrowViewDA;
import com.mft.model.entity.Borrow;

public class BorrowBl {
    public static void add(Borrow borrow) throws Exception{
        try (BorrowDA borrowDA = new BorrowDA()){
            borrowDA.add(borrow);
        }
    }
    public static void update(Borrow borrow) throws Exception{
        try (BorrowDA borrowDA = new BorrowDA()){
            borrowDA.update(borrow);
        }
    }
    public static void remove(int personId) throws Exception{
        try (BorrowDA borrowDA = new BorrowDA()){
            borrowDA.remove(personId);
        }
    }
    public static void findAll() throws Exception{
        try (BorrowViewDA borrowViewDA = new BorrowViewDA()){
            borrowViewDA.findAll();
        }
    }

}
