package org.de.jdbc.mapper;

import java.time.LocalDateTime;

public class Product {

    int id;
    String name;
    LocalDateTime updatedAt;
    String contents;
    int price;

    public String getContents() {
        return contents;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public LocalDateTime getUpdatedAt(){
        return updatedAt;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Product(int id, String name, LocalDateTime updatedAt, String contents, int price){
        this.id = id;
        this.name = name;
        this.updatedAt = updatedAt;
        this.contents = contents;
        this.price = price;
    }

    @Override
    public String toString(){
        return "Product{" +
                "id=" + id +
                "name=" + name +
                "updatedAt=" + updatedAt +
                "contents=" + contents +
                "price=" + price +
                "}";
    }
}
