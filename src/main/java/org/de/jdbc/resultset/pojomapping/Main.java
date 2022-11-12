package org.de.jdbc.resultset.pojomapping;

import org.de.jdbc.mapper.Product;
import org.de.jdbc.mapper.ResultSetMapper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){

        try {
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/de-jdbc", "root", null);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from product");

            List<Product> products = new ArrayList<>();
            while (rs.next()) {
                Product product  = ResultSetMapper.create(rs);
                products.add(product);
            }
            products.stream().forEach(it -> it.setPrice(it.getPrice() - 10));
            con.close();

            } catch (Exception e) {System.out.println(e);}
    }
}
