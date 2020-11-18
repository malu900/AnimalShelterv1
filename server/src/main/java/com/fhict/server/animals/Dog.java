package com.fhict.server.animals;

import com.fhict.server.Gender;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Dog extends Animal{

    private LocalDateTime LastWalk;
    private Boolean NeedsWalk;

    public Dog(String name, Gender gender){
        super(name, gender);
        this.LastWalk = LocalDateTime.now();
    }
    public Dog(String name, double price, Gender gender){
        super(name, price, gender);
        this.LastWalk = LocalDateTime.now();
    }
    public LocalDateTime getLastWalk() {
        return LastWalk;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format(", last walk: %s", this.LastWalk.format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss")));
    }

    public Boolean getNeedsWalk() {
        return (Duration.between(LocalDateTime.now(), this.LastWalk)).toDays() > 0;
    }
}
