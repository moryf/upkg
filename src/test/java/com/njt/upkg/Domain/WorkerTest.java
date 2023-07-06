package com.njt.upkg.Domain;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WorkerTest {

    @Test
    public void testGettersAndSetters() {
        Worker worker = new Worker();

        worker.setId(1);
        assertEquals(1, worker.getId());

        worker.setName("John Doe");
        assertEquals("John Doe", worker.getName());

        worker.setAddress("123 Main St");
        assertEquals("123 Main St", worker.getAddress());

        worker.setPhone("555-1234");
        assertEquals("555-1234", worker.getPhone());

        worker.setEmail("john.doe@example.com");
        assertEquals("john.doe@example.com", worker.getEmail());

        worker.setType(WorkerType.Kvalifikovani);
        assertEquals(WorkerType.Kvalifikovani, worker.getType());

        worker.setPricePerHour(350f);
        assertEquals(350f, worker.getPricePerHour(), 0.01);
    }

    @Test
    public void testIllegalArgumentExceptionInSetName() {
        Worker worker = new Worker();

        assertThrows(IllegalArgumentException.class, () -> worker.setName(null));
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
        Worker worker = new Worker(1, "John Doe", "123 Main St", "555-1234", "john.doe@example.com", WorkerType.Kvalifikovani, 10.5f);

        String expectedToString = "Worker{id=1, name='John Doe', address='123 Main St', phone='555-1234', email='john.doe@example.com', type=Kvalifikovani, pricePerHour=10.5}";

        assertEquals(expectedToString, worker.toString());
    }
}

