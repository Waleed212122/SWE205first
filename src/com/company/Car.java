package com.company;

import javafx.geometry.HorizontalDirection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;

public class Car {
    protected String year;
    protected String brand;
    protected String name;
    protected String type;
    protected String plate;
    protected String price;
    private String status;
    private String color;

    public Car(String year, String brand, String name, String type, String plate, String price, String status, String color) {
        this.year = year;
        this.brand = brand;
        this.name = name;
        this.type = type;
        this.plate = plate;
        this.price = price;
        this.status = status;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getPlate() {
        return plate;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public String getYear() {
        return year;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public void available() {
        this.status = "available";
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    public void reserved() {
        this.status = "reserved";

    }

    @Override
    public String toString() {
        return year +" "+ brand +" "+ name +" "+ type +" "+ plate +" "+ price +" "+ status +" "+ color;
    }

}

