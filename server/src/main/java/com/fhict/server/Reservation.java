package com.fhict.server;

import com.fhict.server.animals.Animal;
import com.fhict.server.animals.Cat;
import com.fhict.server.animals.Dog;
import com.fhict.server.Gender;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/*
    https://www.tutorialspoint.com/design_pattern/observer_pattern.htm
    Subject
    Concrete class
 */
public class Reservation {
    private ArrayList<Animal> animals = new ArrayList<>();


    public void NewCat(String name, Gender gender, String badHabits) {
        this.getAnimals().add(new Cat(name, gender, badHabits));
    }

    public void NewDog(String name, Gender gender) {
        this.getAnimals().add(new Dog(name, gender));
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

}
