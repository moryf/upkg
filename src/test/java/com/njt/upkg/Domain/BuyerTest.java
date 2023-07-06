package com.njt.upkg.Domain;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BuyerTest {

    @Test
    public void testGettersAndSetters() {
        Buyer buyer = new Buyer();

        buyer.setId(1);
        assertEquals(1, buyer.getId());

        buyer.setName("John Doe");
        assertEquals("John Doe", buyer.getName());

        buyer.setNumber("1234567890");
        assertEquals("1234567890", buyer.getNumber());

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

        assertThrows(IllegalArgumentException.class, () -> buyer.setId(0));
        assertThrows(IllegalArgumentException.class, () -> buyer.setId(-1));
    }


    @Test
    public void testToString() {
        Buyer buyer = new Buyer(1, "John Doe", "1234567890", "john@example.com");

        String expectedToString = "Buyer{id=1, name='John Doe', number='1234567890', email='john@example.com'}";

        assertEquals(expectedToString, buyer.toString());
    }
}

