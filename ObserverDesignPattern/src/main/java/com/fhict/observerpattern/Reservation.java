package com.fhict.observerpattern;

import com.fhict.observerpattern.animals.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/*
    Subject
 */
public interface Reservation {
    void registerObserver();
    void unregisterObserver();
    void notifyObserver();
//    void addAnimal(Animal animal);
//    void notifyObservers(Animal animal);

//    void removeAnimal(Animal animal);
//    ArrayList<Animal> animals = new ArrayList<>();
//
//    void NewCat(String name, Gender gender, String badHabits) {
//        this.getAnimals().add(new Cat(name, gender, badHabits));
//    }
//
//    void NewDog(String name, Gender gender) {
//        this.getAnimals().add(new Dog(name, gender));
//    }
//
//    ArrayList<Animal> getAnimals() {
//        return animals;
//    }
//
//    void setAnimals(ArrayList<Animal> animals) {
//        this.animals = animals;
//    }
}
