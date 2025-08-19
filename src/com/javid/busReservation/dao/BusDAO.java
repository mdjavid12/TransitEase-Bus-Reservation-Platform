package com.javid.busReservation.dao;

import com.javid.busReservation.util.DbConnection;

import java.sql.*;

public class BusDAO {
    //For accessing,fetching and inserting. DB related operation
    public void displayBusInfo() throws SQLException {
        String query =" Select * from bus";
        Connection con= DbConnection.getConnection();
        Statement st= con.createStatement();
        ResultSet rs=st.executeQuery(query);

        while(rs.next()) {
            System.out.println("Bus No: " + rs.getInt(1));
            if(rs.getInt(2)==0)
                System.out.println("Type: Non-AC ");
            else
                System.out.println("Type: AC ");
            System.out.println("Capacity: "+ rs.getInt(3)+"\n");
        }
        System.out.println("**********************************\n");

    }

    public int getCapacity(int id) throws SQLException{
        String query ="Select capacity from bus where id=" +id;
        Connection con= DbConnection.getConnection();
        Statement st= con.createStatement();
        ResultSet rs=st.executeQuery(query);
        rs.next();
        return rs.getInt(1);
    }
}


