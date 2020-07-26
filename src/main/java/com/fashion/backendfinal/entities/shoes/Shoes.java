package com.fashion.backendfinal.entities.shoes;

public class Shoes {
    Integer id;
    String size;
    String colour;
    String brand;
    String type;
    String forGender;
    double price;
    String image;

    public Shoes(Integer id, String size, String colour, String brand, String type, String forGender, double price, String image) {
        this.id = id;
        this.size = size;
        this.colour = colour;
        this.brand = brand;
        this.type = type;
        this.forGender = forGender;
        this.price = price;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getForGender() {
        return forGender;
    }

    public void setForGender(String forGender) {
        this.forGender = forGender;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
