package com.mft.model.da;

import com.mft.model.entity.Book;
import com.mft.model.utils.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDA implements AutoCloseable{
    private Connection connection;
    private PreparedStatement statement;
    private List<Book> bookList = new ArrayList<>();

    public BookDA() throws SQLException {
       connection = ConnectionProvider.getConnectionProvider().getConnection();
    }

    public Book add(Book book) throws SQLException {
        statement = connection.prepareStatement("select book_seq.nextval as id from dual");
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        book.setId(resultSet.getInt("id"));

       statement = connection.prepareStatement("insert into book(id,name,writer,count) values (?,?,?,?)");
       statement.setInt(1,book.getId());
       statement.setString(2,book.getName());
       statement.setString(3,book.getWriter());
       statement.setInt(4,book.getCount());
       if(statement.executeUpdate() == 1){
          return book;
       }else {
           return null;
       }
    }
    public Book update(Book book) throws SQLException {
        statement = connection.prepareStatement("update book set name=?,writer=?,count=?  where id=?");
        statement.setString(1,book.getName());
        statement.setString(2,book.getWriter());
        statement.setInt(3,book.getCount());
        statement.setInt(4,book.getId());
        if(statement.executeUpdate() == 1){
            return book;
        }else {
            return null;
        }
    }
    public Book remove(int id) throws SQLException {
        Book book = findById(id);
        statement = connection.prepareStatement("delete from book where id=?");
        statement.setInt(1,id);
        if(statement.executeUpdate() == 1){
            return book;
        }else {
            return null;
        }

    }
    public List<Book> findAll() throws SQLException {
        statement = connection.prepareStatement("select * from book");
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            Book book = new Book()
                    .setId(resultSet.getInt("id"))
                    .setName(resultSet.getString("name"))
                    .setWriter(resultSet.getString("writer"))
                    .setCount(resultSet.getInt("count"));
            bookList.add(book);
        }
        System.out.println(bookList);
        return bookList;
    }
    public List<Book> findAllByNameOrWriter(String name,String writer,boolean match) throws SQLException {
        String sqlCommand;
        if(match){
            sqlCommand = "select * from book where name=? or writer=?";
        }else {
            name = "%" + name + "%";
            writer = "%" + writer + "%";
            sqlCommand = "select * from book where name like ? or writer like ?";
        }
        statement = connection.prepareStatement(sqlCommand);
        statement.setString(1,name);
        statement.setString(2,writer);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            Book book = new Book()
                    .setId(resultSet.getInt("id"))
                    .setName(resultSet.getString("name"))
                    .setWriter(resultSet.getString("writer"))
                    .setCount(resultSet.getInt("count"));
            bookList.add(book);
        }
        System.out.println(bookList);
        return bookList;
    }
    public List<Book> findAvailableByName(String name) throws SQLException {
        statement = connection.prepareStatement("select * from book where count > 0 and name=?");
        statement.setString(1,name);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            Book book = new Book()
                    .setId(resultSet.getInt("id"))
                    .setName(resultSet.getString("name"))
                    .setWriter(resultSet.getString("writer"))
                    .setCount(resultSet.getInt("count"));
            bookList.add(book);
        }
        System.out.println(bookList);
        return bookList;
    }
    public Book findById(int id) throws SQLException {
        statement = connection.prepareStatement("select * from book where id=?");
        statement.setInt(1,id);
        ResultSet resultSet = statement.executeQuery();
        resultSet.next();
        Book book = new Book()
                .setId(resultSet.getInt("id"))
                .setName(resultSet.getString("name"))
                .setWriter(resultSet.getString("writer"))
                .setCount(resultSet.getInt("count"));
        System.out.println(book);
        return book;
    }

    @Override
    public void close() throws Exception {
        statement.close();
        connection.close();
    }
}
