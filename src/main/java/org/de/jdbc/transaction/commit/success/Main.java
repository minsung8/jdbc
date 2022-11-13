package org.de.jdbc.transaction.commit.success;

import org.de.jdbc.mapper.ResultSetMapper;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {

        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/de-jdbc", "root", null);
        con.setAutoCommit(false);
        Statement stmt = con.createStatement();
        stmt.executeUpdate("DELETE from review where product_id = 1");
        stmt.executeUpdate("DELETE from product where id = 1");

        con.commit();
        con.close();

        Connection con2 = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/de-jdbc", "root", null);
        Statement stmt2 = con2.createStatement();

        ResultSet rs2 = stmt2.executeQuery("" +
                "select * from product where id = 1");

        if (rs2.next()){
            ResultSetMapper.printRs(rs2);
        } else {
            System.out.println("no result");
        }
        con2.close();
    }
}
