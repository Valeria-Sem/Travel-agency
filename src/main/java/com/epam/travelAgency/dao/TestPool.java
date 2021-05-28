package com.epam.travelAgency.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestPool {
    public static void main(String[] args) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("database");
        String dbUrl = resourceBundle.getString("dbUrl");
        String dbUser = resourceBundle.getString("dbUser");
        String dbPassword = resourceBundle.getString("dbPassword");

        Connection conn = null;
        ConnectionPool pool = new ConnectionPool(dbUrl, dbUser, dbPassword, 2);
        try{
            conn = pool.getConnection();
            try(Statement statement = conn.createStatement()){
                ResultSet res = statement.executeQuery("select * from tour");
                System.out.println("There are below tables: ");
                while (res.next()){
//                    System.out.print(res.getString("id"));
//                    System.out.print("| ");
//                    System.out.print(res.getString("e_mail"));
//                    System.out.print("| ");
//                    System.out.print(res.getString("password"));
//                    System.out.print("| ");
//                    System.out.print(res.getString("role"));
//                    System.out.println();

                    System.out.print(res.getString(1));
                    System.out.print("| ");
                    System.out.print(res.getString(2));
                    System.out.print("| ");
                    System.out.print(res.getString(3));
                    System.out.print("| ");
                    System.out.print(res.getString(4));
                    System.out.print("| ");
                    System.out.print(res.getString(5));
                    System.out.print("| ");
                    System.out.print(res.getString(6));
                    System.out.print("| ");
                    System.out.print(res.getString(7));
                    System.out.print("| ");
                    System.out.print(res.getString(8));
                    System.out.print("| ");
                    System.out.print(res.getString(9));
                    System.out.print("| ");
                    System.out.print(res.getString(10));
                    System.out.print("| ");
                    System.out.print(res.getString(11));
                    System.out.print("| ");
                    System.out.print(res.getString(12));
                    System.out.print("| ");
                    System.out.print(res.getString(13));
                    System.out.print("| ");
                    System.out.print(res.getString(14));
                    System.out.println();
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            if(conn != null){
                try{
                    pool.returnConnection(conn);
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
