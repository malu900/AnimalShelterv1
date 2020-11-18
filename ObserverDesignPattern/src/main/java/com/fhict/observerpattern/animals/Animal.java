package com.fhict.observerpattern.animals;

import com.fhict.observerpattern.Reservation;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal implements Reservation {
    private List<String> observers = new ArrayList<>();


}
