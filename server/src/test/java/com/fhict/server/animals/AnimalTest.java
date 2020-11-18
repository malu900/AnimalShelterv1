package com.fhict.server.animals;

import com.fhict.server.Gender;
import com.fhict.server.animals.Animal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    private Animal animal;

    @BeforeEach
    public void TestInitialize() {
        this.animal = new Dog("Ugly Duckling", Gender.Male);
    }

    @Test
    public void TestConstructor()
    {
        assertTrue(true);
        assertEquals("Ugly Duckling", this.animal.getName());
        assertEquals(Gender.Male, this.animal.getGender());
        assertNull(this.animal.getReservedBy());
    }

    @Test
    public void TestReservation()
    {
        assertNull(this.animal.getReservedBy());
        assertTrue(this.animal.Reserve("Jane Doe"));
        assertNotNull(this.animal.getReservedBy());
        assertEquals("Jane Doe", this.animal.getReservedBy().getName());
        assertFalse(this.animal.Reserve("John Doe"));
    }

    @Test
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

        // https://stackoverflow.com/questions/26376073/junit-equivalent-to-nunit-assert-inconclusive
        // public static void inconclusive() {
        // throw new AssumptionViolatedException("Inconclusive");
        //}
    }
}
