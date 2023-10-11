package com.mft.controller.exceptions;

import java.sql.SQLException;

public class ExceptionWrapper {
    public static void getMassage(Exception e){
        if (e instanceof SQLException){
            System.out.println("Sql Error!" + e.getMessage());
        }else if (e instanceof ArithmeticException){
            System.out.println("Mathematical Error!" + e.getMessage());
        }else if (e instanceof ArrayIndexOutOfBoundsException){
            System.out.println("Array Index Error!" + e.getMessage());
        }else {
            System.out.println("Unknown Error!" + e.getMessage());
        }
    }
}
