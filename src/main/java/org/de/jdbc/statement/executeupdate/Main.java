package org.de.jdbc.statement.executeupdate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args){

        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/de-jdbc", "root", null);
            Statement stmt = con.createStatement();
            int res = stmt.executeUpdate("UPDATE product SET price = price + 10000 WHERE id = 1");

            System.out.println("success : " + res);

            con.close();

            }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
