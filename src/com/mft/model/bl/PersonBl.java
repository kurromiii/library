package com.mft.model.bl;

import com.mft.model.da.PersonDA;
import com.mft.model.entity.Person;

public class PersonBl {
    public static void add(Person person) throws Exception {
        try(PersonDA personDA = new PersonDA()){
            personDA.add(person);
        }
    }
    public static void update(Person person) throws Exception {
        try(PersonDA personDA = new PersonDA()){
            personDA.update(person);
        }
    }
    public static void remove(int id) throws Exception {
        try(PersonDA personDA = new PersonDA()){
            personDA.remove(id);
        }
    }
    public static void findAll() throws Exception{
        try(PersonDA personDA = new PersonDA()){
            personDA.findAll();
        }
    }
    public static void findAllByNameAndFamily(String name,String family,boolean match) throws Exception{
        try(PersonDA personDA = new PersonDA()){
           personDA.findAllByNameAndFamily(name,family,match);
        }
    }
    public static void findById(int id) throws Exception{
        try(PersonDA personDA = new PersonDA()){
            personDA.findById(id);
        }
    }
}
