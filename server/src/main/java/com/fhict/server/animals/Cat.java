package com.fhict.server.animals;

import com.fhict.server.Gender;

public class Cat extends Animal{
    private String badHabits;

    public Cat(String name, Gender gender, String badHabits){
        super(name, gender);
        this.badHabits = badHabits;
    }
    public Cat(String name, double price, Gender gender, String badHabits){
        super(name, price, gender);
        this.badHabits = badHabits;
    }

    public String getBadHabits() {
        return badHabits;
    }

    void setBadHabits(String badHabits) {
        this.badHabits = badHabits;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format(", bad habits: %s", this.badHabits.toLowerCase());
    }
}
