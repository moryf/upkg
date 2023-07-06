package com.njt.upkg.Domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MaterialTest {

    @Test
    public void testGettersAndSetters() {
        Material material = new Material();

        material.setId(1);
        assertEquals(1, material.getId());

        material.setName("Bubreg 1");
        assertEquals("Bubreg 1", material.getName());

        material.setType(MaterialType.Bubreg);
        assertEquals(MaterialType.Bubreg, material.getType());

        material.setInDepo(100);
        assertEquals(100, material.getInDepo());

        material.setWeight(2.5f);
        assertEquals(2.5f, material.getWeight(), 0.01);

        material.setArea(5.0f);
        assertEquals(5.0f, material.getArea(), 0.01);

        material.setZinked(true);
        assertTrue(material.isZinked());

        material.setPainted(false);
        assertFalse(material.isPainted());

        material.setMeasuringUnit(MeasuringUnit.Komad);
        assertEquals(MeasuringUnit.Komad, material.getMeasuringUnit());

        material.setPrice(50.5f);
        assertEquals(50.5f, material.getPrice(), 0.01);
    }

    @Test
    public void testIllegalArgumentExceptionInSetName() {
        Material material = new Material();

        assertThrows(IllegalArgumentException.class, () -> material.setName(null));
        assertThrows(IllegalArgumentException.class, () -> material.setName(""));
    }

    @Test
    public void testIllegalArgumentExceptionInSetType() {
        Material material = new Material();

        assertThrows(IllegalArgumentException.class, () -> material.setType(null));
    }

    @Test
    public void testIllegalArgumentExceptionInSetInDepo() {
        Material material = new Material();

        assertThrows(IllegalArgumentException.class, () -> material.setInDepo(-1));
    }

    @Test
    public void testIllegalArgumentExceptionInSetWeight() {
        Material material = new Material();

        assertThrows(IllegalArgumentException.class, () -> material.setWeight(-1.0f));
    }

    @Test
    public void testIllegalArgumentExceptionInSetArea() {
        Material material = new Material();

        assertThrows(IllegalArgumentException.class, () -> material.setArea(-1.0f));
    }

    @Test
    public void testToString() {
        Material material = new Material(1, "Bubreg 1", MaterialType.Bubreg, 100, 2.5f, 5.0f, true, false, MeasuringUnit.Komad, 10.5f);

        String expectedToString = "Material{id=1, name='Bubreg 1', type=Bubreg, inDepo=100, weight=2.5, area=5.0, zinked=true, painted=false, measuringUnit=Komad, price=10.5}";

        assertEquals(expectedToString, material.toString());
    }
}
