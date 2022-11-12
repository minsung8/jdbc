package org.de.jdbc.callablestatement.function;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/de-jdbc", "root", null);

        CallableStatement stmtFunctionCall = con.prepareCall("{? = call add_event_prefix(?)}");
        String originalContent = "original";
        System.out.println("original content : " + originalContent);

        stmtFunctionCall.setString(2, originalContent);
        stmtFunctionCall.registerOutParameter(1, Types.VARCHAR);

        boolean result2 = stmtFunctionCall.execute();
        System.out.println(result2);
        System.out.println("After prefix : " + stmtFunctionCall.getString(1));

    }
}
