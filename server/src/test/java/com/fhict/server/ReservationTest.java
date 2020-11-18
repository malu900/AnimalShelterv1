package com.fhict.server;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReservationTest {
    private Reservation reservation;

    @BeforeEach
    public void TestInitialize() {
        this.reservation = new Reservation();
    }

    @Test
    public void TestNewCat() {
        assertEquals(0, reservation.getAnimals().size());
        this.reservation.NewCat("Ms. Meow", Gender.Female, "Scratches couch");
        assertEquals(1, this.reservation.getAnimals().size());
    }

    @Test
    public void TestNewDog() {
        assertEquals(0, reservation.getAnimals().size());
        this.reservation.NewDog("Ms. Meow", Gender.Female);
        assertEquals(1, this.reservation.getAnimals().size());
    }

}
