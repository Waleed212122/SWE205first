package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Customer extends User {
        private ArrayList<Reservation> record;
        private Reservation reservation;

    public Customer(String name, String age, String email, String id) {
        super(name, age, email, id);
    }


    public void book(Car car, Customer customer, Date datein, Date dateout) {
        this.reservation = new Reservation(car,customer,datein,dateout);
        record.add(reservation);
    }

    public ArrayList<Reservation> getRecord() {
        return record;
    }

    public void access(Reservation res){
        res.toString();

    }

    public void modify(){

    }

    public void register(){

    }



}
