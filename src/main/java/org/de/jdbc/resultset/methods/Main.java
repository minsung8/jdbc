package org.de.jdbc.resultset.methods;

import java.sql.*;

public class Main {

    public static void main(String[] args){

        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/de-jdbc", "root", null);
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select id from product");

            if (rs.next()){
                printRs(rs);
            }

            if (rs.last()){
                printRs(rs);
            }

            rs.last();

            if (rs.previous()){
                printRs(rs);
            }

            if (rs.absolute(2)){
                printRs(rs);
            }

            if (rs.relative(2)){
                printRs(rs);
            }

            if (rs.relative(-2)){
                printRs(rs);
            }

            }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void printRs(ResultSet rs) throws SQLException {
        System.out.println(rs.getInt(1));
    }
}
