package com.company;

public class Receptionist extends User {


    public Receptionist(String name, String age, String email, String id) {
        super(name, age, email, id);
    }

    public void Checkout(Car car){
        car.reserved();

    }

    public void Checkin(Car car){
        car.available();

    }
}
