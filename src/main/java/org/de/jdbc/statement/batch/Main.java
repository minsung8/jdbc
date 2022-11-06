package org.de.jdbc.statement.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {

    public static void main(String[] args){

        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/de-jdbc", "root", null);
            Statement stmt = con.createStatement();
            stmt.addBatch("update product set price = price + 10 where id = 1");
            stmt.addBatch("update product set price = price + 10 where id = 2");
            stmt.addBatch("update product set price = price + 10 where id = 3");

            int[] res = stmt.executeBatch();

            System.out.println("success : ");

            for (int r : res){
                System.out.println(r);
            }

            con.close();

            }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
