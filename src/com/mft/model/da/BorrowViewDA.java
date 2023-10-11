package com.mft.model.da;

import com.mft.model.entity.BorrowView;
import com.mft.model.utils.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorrowViewDA implements AutoCloseable{
    private Connection connection;
    private PreparedStatement statement;
    private List<BorrowView> borrowList = new ArrayList();
    public BorrowViewDA() throws SQLException {
        connection = ConnectionProvider.getConnectionProvider().getConnection();
    }
    public List<BorrowView> findAll() throws SQLException {
        statement = connection.prepareStatement("select * from borrow_view");

        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            BorrowView borrowView = new BorrowView()
                    .setPersonId(resultSet.getInt("person_id"))
                    .setPersonName(resultSet.getString("person_name"))
                    .setPersonFamily(resultSet.getString("person_family"))
                    .setBookId(resultSet.getInt("book_id"))
                    .setBookName(resultSet.getString("book_name"))
                    .setBookWriter(resultSet.getString("book_writer"))
                    .setCount(resultSet.getInt("book_count"))
                    .setBorrowTime(resultSet.getTimestamp("borrow_date").toLocalDateTime());
            borrowList.add(borrowView);
        }
        System.out.println(borrowList);
        return borrowList;
    }

    @Override
    public void close() throws Exception {
        statement.close();
        connection.close();
    }
}
