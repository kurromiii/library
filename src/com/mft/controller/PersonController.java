package com.mft.controller;

import com.mft.controller.exceptions.ExceptionWrapper;
import com.mft.model.bl.PersonBl;
import com.mft.model.entity.Person;

import java.util.Scanner;

public class PersonController {
    //it must be string not Person, user shouldn't have any access to our entities
    public static void add(String name,String family) {
        //validation (we need to create the object)
        if (name != null & family != null) {
            Person person = new Person(name, family);
            //Exception handling
            try {
                PersonBl.add(person);
            } catch (Exception e) {
                ExceptionWrapper.getMassage(e);
            }
        }
    }
    public static void update(int id,String name,String family){
        if (name != null & family != null) {
            Person person = new Person(id,name,family);
            try {
                PersonBl.update(person);
            } catch (Exception e) {
                ExceptionWrapper.getMassage(e);
            }
        }
    }
    public static void remove(int id){
        if (id != 0) {
            Person person = new Person(id);
            try {
                PersonBl.remove(id);
            } catch (Exception e) {
                ExceptionWrapper.getMassage(e);
            }
        }
    }
    public static void findAll(){
        Person person = new Person();
        try {
            PersonBl.findAll();
        } catch (Exception e) {
            ExceptionWrapper.getMassage(e);
        }
    }
    public static void findAllByNameAndFamily(String name,String family,boolean match){
        if (name != null & family != null) {
            Person person = new Person(name,family);
        }
        try {
            PersonBl.findAllByNameAndFamily(name,family,match);
        } catch (Exception e) {
            ExceptionWrapper.getMassage(e);
        }
    }
    public static void findById(int id){
        if (id != 0){
            Person person = new Person(id);
        }
        try {
            PersonBl.findById(id);
        } catch (Exception e) {
            ExceptionWrapper.getMassage(e);
        }
    }
}
