package com.fhict.server.animals;

import com.fhict.server.Gender;
import com.fhict.server.animals.Cat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CatTest {
    private Cat cat;

    @BeforeEach
    public void TestInitialize() {
        this.cat = new Cat("Ms. Meow", Gender.Female, "Scratches couch");
    }

    @Test
    public void TestConstructor()
    {
        assertEquals("Ms. Meow", this.cat.getName());
        assertEquals(Gender.Female, this.cat.getGender());
        assertNull(this.cat.getReservedBy());
        assertEquals("Scratches couch", this.cat.getBadHabits());
    }

    @Test
    public void TestReservation()
    {
        assertNull(this.cat.getReservedBy());
        assertTrue(this.cat.Reserve("John Doe"));
        assertNotNull(this.cat.Reserve("John Doe"));
        assertNotNull(this.cat.getReservedBy());
        assertEquals("John Doe", this.cat.getReservedBy().getName());
        assertFalse(this.cat.Reserve("Jane Doe"));
    }
}
