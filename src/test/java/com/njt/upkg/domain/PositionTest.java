package com.njt.upkg.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    @Test
    public void testGetId() {
        Position position = new Position();
        position.setId(1L);
        assertEquals(1L, position.getId());
    }

    @Test
    public void testGetProject() {
        Position position = new Position();
        Project project = new Project();
        position.setProject(project);
        assertEquals(project, position.getProject());
    }

    @Test
    public void testGetName() {
        Position position = new Position();
        position.setName("Position A");
        assertEquals("Position A", position.getName());
    }

    @Test
    public void testIsReadyToMount() {
        Position position = new Position();
        position.setReadyToMount(true);
        assertTrue(position.isReadyToMount());
    }

    @Test
    public void testIsMounted() {
        Position position = new Position();
        position.setMounted(true);
        assertTrue(position.isMounted());
    }


    @Test
    public void testIllegalArgumentExceptionInSetIdWithZero() {
        Position position = new Position();
        assertThrows(IllegalArgumentException.class, () -> position.setId(0L));
    }

    @Test
    public void testIllegalArgumentExceptionInSetIdWithNegativeValue() {
        Position position = new Position();
        assertThrows(IllegalArgumentException.class, () -> position.setId(-1L));
    }


    @Test
    public void testIllegalArgumentExceptionInSetNameWithNull() {
        Position position = new Position();
        assertThrows(IllegalArgumentException.class, () -> position.setName(null));
    }

    @Test
    public void testIllegalArgumentExceptionInSetNameWithEmptyString() {
        Position position = new Position();
        assertThrows(IllegalArgumentException.class, () -> position.setName(""));
    }


    @Test
    public void testToString() {
        Project project = new Project();
        Position position = new Position(1L, project, "Position A", true, false);

        String expectedToString = "Position{id=1, project=" + project + ", name='Position A', readyToMount=true, mounted=false}";

        assertEquals(expectedToString, position.toString());
    }
}

