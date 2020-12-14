package com.company;

import java.util.Date;
import java.util.Random;

public class Reservation {
    Random random = new Random(0);
    protected int reference = random.nextInt(130394);
    protected Car car;
    protected Customer customer;
    private java.util.Date datein;
    private java.util.Date dateout;


    public Reservation( Car car, Customer customer, Date datein, Date dateout) {
        this.car = car;
        this.customer = customer;
        this.datein = datein;
        this.dateout = dateout;
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Date getDatein() {
        return datein;
    }

    public Date getDateout() {
        return dateout;
    }

    public int getReference() {
        return reference;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setDatein(Date datein) {
        this.datein = datein;
    }

    public void setDateout(Date dateout) {
        this.dateout = dateout;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reference=" + reference +
                ", car=" + car +
                ", customer=" + customer +
                ", datein=" + datein +
                ", dateout=" + dateout +
                '}';
    }
}



