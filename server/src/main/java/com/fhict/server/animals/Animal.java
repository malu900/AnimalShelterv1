package com.fhict.server.animals;

import com.fhict.server.Gender;
import com.fhict.server.ISellable;

import java.time.LocalDateTime;

/*
    Observer
 */

public abstract class Animal implements ISellable {
    private String name;
    private Gender gender;
    private Reservor reservedBy;
    private double price;

    public Animal(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
    }
    public Animal(String name, double price, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.price = price;
    }

    // getter setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    private void setGender(Gender gender) {
        this.gender = gender;
    }

    public Reservor getReservedBy() {
        return reservedBy;
    }

    public void setReservedBy(Reservor reservedBy) {
        this.reservedBy = reservedBy;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    // Methods
    public Boolean Reserve(String reservedBy) {
        if (this.reservedBy == null)
        {
            this.reservedBy = new Reservor(reservedBy, LocalDateTime.now());
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String reserved = "not reserved";
        String pricee = null;
        if(this.reservedBy != null) {
            reserved = String.format("reserved by %s", this.reservedBy.getName());
        }
        if(this.price != 0) {
            pricee = String.format("%s", this.getPrice());
        }
        return String.format(" %s , %s , %s, %s", this.name, this.gender.toString(), reserved, pricee);
    }
}

