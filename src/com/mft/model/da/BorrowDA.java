package com.mft.model.da;

import com.mft.model.entity.Borrow;
import com.mft.model.entity.Person;
import com.mft.model.utils.ConnectionProvider;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BorrowDA implements AutoCloseable{
    private PreparedStatement statement;
    private Connection connection;
    public BorrowDA() throws SQLException {
         connection = ConnectionProvider.getConnectionProvider().getConnection();
    }
    public Borrow add(Borrow borrow) throws SQLException {
            statement = connection.prepareStatement("insert into borrow (person_id,book_id,borrow_date) values (?,?,?)");
            statement.setInt(1, borrow.getPersonId());
            statement.setInt(2, borrow.getBookId());
            statement.setTimestamp(3, Timestamp.valueOf(borrow.getBorrowDate()));
            if (statement.executeUpdate() == 1) {
                return borrow;
            } else {
                return null;
            }
    }
    public Borrow update(Borrow borrow) throws SQLException {
        statement = connection.prepareStatement("update borrow set person_id=?,book_id=?,borrow_date=? where person_id=?");
        statement.setInt(1,borrow.getPersonId());
        statement.setInt(2,borrow.getBookId());
        statement.setTimestamp(3, Timestamp.valueOf(borrow.getBorrowDate()));
        statement.setInt(4,borrow.getPersonId());
        if (statement.executeUpdate() == 1){
            return borrow;
        }else {
            return null;
        }
    }
    public int remove(int personId) throws SQLException {
        statement = connection.prepareStatement("delete from borrow where person_id=?");
        statement.setInt(1,personId);
        if (statement.executeUpdate() == 1){
            return personId;
        }else {
            return 0;
        }
    }

    @Override
    public void close() throws Exception {
        statement.close();
        connection.close();
    }
}
