package com.mft.model.da;

import com.mft.model.entity.Person;
import com.mft.model.utils.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDA implements AutoCloseable {
    private PreparedStatement statement;
    private Connection connection;

    private List<Person> personList = new ArrayList<>();

    public PersonDA() throws SQLException {
        connection = ConnectionProvider.getConnectionProvider().getConnection();
    }
//not void because we need to send sth to user
    public Person add(Person person) throws SQLException {
        //for getting id from database
        statement = connection.prepareStatement("select person_seq.nextval as id from dual");
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        person.setId(resultSet.getInt("id"));

        statement = connection.prepareStatement("insert into person(id,name,family) values (?,?,?)");
        statement.setInt(1,person.getId());
        statement.setString(2,person.getName());
        statement.setString(3,person.getFamily());
        //to check that exactly 1 record has been added
        if (statement.executeUpdate() == 1) {
           return person;
        }else {
            return null;
        }
    }
    public Person update(Person person) throws SQLException {
        statement = connection.prepareStatement("update person set name=?,family=? where id=?");
        statement.setString(1,person.getName());
        statement.setString(2,person.getFamily());
        statement.setInt(3,person.getId());
        if (statement.executeUpdate() == 1) {
            return person;
        }else {
            return null;
        }
    }
    /* public void remove(int id) throws SQLException {
        statement = connection.prepareStatement("delete from person where id=?");
        statement.setInt(1,id);
        statement.executeUpdate();
        close();
    }*/
    public Person remove(int id) throws SQLException {
        Person person = findById(id);
        statement = connection.prepareStatement("delete from person where id=?");
        statement.setInt(1,id);
        if (statement.executeUpdate() == 1) {
            return person;
        }else {
            return null;
        }

    }
    public List<Person> findAll() throws SQLException {
        statement = connection.prepareStatement("select * from person");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            //getter and setter with builder pattern
            Person person = new Person()
                    .setId(resultSet.getInt("id"))
                    .setName(resultSet.getString("name"))
                    .setFamily(resultSet.getString("family"));
            personList.add(person);
        }
        System.out.println(personList);
        return personList;
    }
    //while using scanner for name and family, set match as true or false
    public List<Person> findAllByNameAndFamily(String name,String family,boolean match) throws SQLException {
        String sqlCommand;
        if (match){
            sqlCommand = "select * from person where name=? and family=?";
        }else {
            //contains
            name = "%" + name + "%";
            family = "%" + family + "%";
            sqlCommand = "select * from person where name like ? and family like ?";
        }
        statement = connection.prepareStatement(sqlCommand);
        statement.setString(1, name);
        statement.setString(2,family);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            Person person = new Person()
                    .setId(resultSet.getInt("id"))
                    .setName(resultSet.getString("name"))
                    .setFamily(resultSet.getString("family"));
            personList.add(person);
        }
        System.out.println(personList);
        return personList;
    }
    public Person findById(int id) throws SQLException {
        statement = connection.prepareStatement("select * from person where id=?");
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        Person person = new Person()
                .setId(resultSet.getInt("id"))
                .setName(resultSet.getString("name"))
                .setFamily( resultSet.getString("family"));
        System.out.println(person);
        return person;
    }

    @Override
    public void close() throws Exception {
        statement.close();
        connection.close();
    }
}
