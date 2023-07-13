package com.njt.upkg.domain;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WorkerTest {

    @Test
    public void testGetId() {
        Worker worker = new Worker();
        worker.setId(1L);
        assertEquals(1L, worker.getId());
    }

    @Test
    public void testGetName() {
        Worker worker = new Worker();
        worker.setName("John Doe");
        assertEquals("John Doe", worker.getName());
    }

    @Test
    public void testGetAddress() {
        Worker worker = new Worker();
        worker.setAddress("123 Main St");
        assertEquals("123 Main St", worker.getAddress());
    }

    @Test
    public void testGetPhone() {
        Worker worker = new Worker();
        worker.setPhone("555-1234");
        assertEquals("555-1234", worker.getPhone());
    }

    @Test
    public void testGetEmail() {
        Worker worker = new Worker();
        worker.setEmail("john.doe@example.com");
        assertEquals("john.doe@example.com", worker.getEmail());
    }

    @Test
    public void testGetType() {
        Worker worker = new Worker();
        worker.setType(WorkerType.Kvalifikovani);
        assertEquals(WorkerType.Kvalifikovani, worker.getType());
    }

    @Test
    public void testGetPricePerHour() {
        Worker worker = new Worker();
        worker.setPricePerHour(350f);
        assertEquals(350f, worker.getPricePerHour(), 0.01);
    }


    @Test
    public void testIllegalArgumentExceptionInSetIdWithZero() {
        Worker worker = new Worker();
        assertThrows(IllegalArgumentException.class, () -> worker.setId(0L));
    }

    @Test
    public void testIllegalArgumentExceptionInSetIdWithNegativeValue() {
        Worker worker = new Worker();
        assertThrows(IllegalArgumentException.class, () -> worker.setId(-1L));
    }


    @Test
    public void testIllegalArgumentExceptionInSetNameWithNull() {
        Worker worker = new Worker();
        assertThrows(IllegalArgumentException.class, () -> worker.setName(null));
    }

    @Test
    public void testIllegalArgumentExceptionInSetNameWithEmptyString() {
        Worker worker = new Worker();
        assertThrows(IllegalArgumentException.class, () -> worker.setName(""));
    }


    @Test
    public void testNullPointerExceptionInSetType() {
        Worker worker = new Worker();

        assertThrows(NullPointerException.class, () -> worker.setType(null));
    }

    @Test
    public void testIllegalArgumentExceptionInSetPricePerHour() {
        Worker worker = new Worker();

        assertThrows(IllegalArgumentException.class, () -> worker.setPricePerHour(-1.0f));
    }

    @Test
    public void testToString() {
        Worker worker = new Worker(1L, "John Doe", "123 Main St", "555-1234", "john.doe@example.com", WorkerType.Kvalifikovani, 10.5f);

        String expectedToString = "Worker{id=1, name='John Doe', address='123 Main St', phone='555-1234', email='john.doe@example.com', type=Kvalifikovani, pricePerHour=10.5}";

        assertEquals(expectedToString, worker.toString());
    }
}

