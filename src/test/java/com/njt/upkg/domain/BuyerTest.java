package com.njt.upkg.domain;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BuyerTest {

    @Test
    public void testGetId() {
        Buyer buyer = new Buyer();
        buyer.setId(1L);
        assertEquals(1, buyer.getId());
    }

    @Test
    public void testGetName() {
        Buyer buyer = new Buyer();
        buyer.setName("John Doe");
        assertEquals("John Doe", buyer.getName());
    }

    @Test
    public void testGetNumber() {
        Buyer buyer = new Buyer();
        buyer.setNumber("1234567890");
        assertEquals("1234567890", buyer.getNumber());
    }

    @Test
    public void testGetEmail() {
        Buyer buyer = new Buyer();
        buyer.setEmail("john@example.com");
        assertEquals("john@example.com", buyer.getEmail());
    }


    @Test
    public void testIllegalArgumentExceptionInSetName() {
        Buyer buyer = new Buyer();

        assertThrows(IllegalArgumentException.class, () -> buyer.setName(null));
        assertThrows(IllegalArgumentException.class, () -> buyer.setName(""));
    }

    @Test
    public void testIllegalArgumentExceptionInSetEmail() {
        Buyer buyer = new Buyer();

        assertThrows(IllegalArgumentException.class, () -> buyer.setEmail(null));
        assertThrows(IllegalArgumentException.class, () -> buyer.setEmail(""));
    }

    @Test
    public void testIllegalArgumentExceptionInSetId() {
        Buyer buyer = new Buyer();

        assertThrows(IllegalArgumentException.class, () -> buyer.setId(0L));
        assertThrows(IllegalArgumentException.class, () -> buyer.setId(-1L));
    }


    @Test
    public void testToString() {
        Buyer buyer = new Buyer(1L, "John Doe", "1234567890", "john@example.com");

        String expectedToString = "Buyer{id=1, name='John Doe', number='1234567890', email='john@example.com'}";

        assertEquals(expectedToString, buyer.toString());
    }
}

