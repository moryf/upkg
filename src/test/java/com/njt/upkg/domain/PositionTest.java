package com.njt.upkg.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {

    @Test
    public void testGettersAndSetters() {
        Position position = new Position();

        position.setId(1L);
        assertEquals(1L, position.getId());

        Project project = new Project();
        position.setProject(project);
        assertEquals(project, position.getProject());

        position.setName("Position A");
        assertEquals("Position A", position.getName());

        position.setReadyToMount(true);
        assertTrue(position.isReadyToMount());

        position.setMounted(true);
        assertTrue(position.isMounted());
    }

    @Test
    public void testIllegalArgumentExceptionInSetId() {
        Position position = new Position();

        assertThrows(IllegalArgumentException.class, () -> position.setId(0L));
        assertThrows(IllegalArgumentException.class, () -> position.setId(-1L));
    }

    @Test
    public void testIllegalArgumentExceptionInSetName() {
        Position position = new Position();

        assertThrows(IllegalArgumentException.class, () -> position.setName(null));
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

