package com.fhict.server.animals;

import com.fhict.server.Gender;
import com.fhict.server.animals.Dog;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class DogTest {
    private Dog dog;

    @BeforeEach
    public void TestInitialize(){
        this.dog = new Dog("Sgt. Woof", Gender.Male);
    }

    @Test
    public void TestConstructor()
    {
        assertEquals("Sgt. Woof", this.dog.getName());
        assertEquals(Gender.Male, this.dog.getGender());
        assertNull(this.dog.getReservedBy());
        assertFalse(this.dog.getNeedsWalk());
    }

    @Test
    public void TestReservation()
    {
        assertNull(this.dog.getReservedBy());
        assertTrue(this.dog.Reserve("John Doe"));
        assertNotNull(this.dog.getReservedBy());
        assertEquals("John Doe", this.dog.getReservedBy().getName());
        assertFalse(this.dog.Reserve("Jane Doe"));
    }

    public void TestReservationTime()
    {
        // TODO: Implement this when interfaces have been explained.
        // We don't yet test the reserved time because it used the current
        // system clock to determine the result. Therefore we cannot check
        // if the values are the same, since two consecutive calls to
        // DateTime.Now are very likely to give different results. There is
        // a way to account for this, but the solution will use interfaces:
        // a concept that is not yet discussed in class. To be implemented.
//        Assert.Inconclusive("Implement this when interfaces have been explained");
    }
}
