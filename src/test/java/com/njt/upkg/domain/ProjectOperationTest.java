package com.njt.upkg.domain;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ProjectOperationTest {

    @Test
    public void testGetId() {
        ProjectOperation operation = new ProjectOperation();
        operation.setId(1L);
        assertEquals(1L, operation.getId());
    }

    @Test
    public void testGetProject() {
        ProjectOperation operation = new ProjectOperation();
        Project project = new Project();
        operation.setProject(project);
        assertEquals(project, operation.getProject());
    }

    @Test
    public void testGetPosition() {
        ProjectOperation operation = new ProjectOperation();
        Position position = new Position();
        operation.setPosition(position);
        assertEquals(position, operation.getPosition());
    }

    @Test
    public void testGetWorker() {
        ProjectOperation operation = new ProjectOperation();
        Worker worker = new Worker();
        operation.setWorker(worker);
        assertEquals(worker, operation.getWorker());
    }

    @Test
    public void testGetType() {
        ProjectOperation operation = new ProjectOperation();
        OperationType type = OperationType.Kovanje;
        operation.setType(type);
        assertEquals(type, operation.getType());
    }

    @Test
    public void testGetStart() {
        ProjectOperation operation = new ProjectOperation();
        Date start = new Date();
        operation.setStart(start);
        assertEquals(start, operation.getStart());
    }

    @Test
    public void testGetEnded() {
        ProjectOperation operation = new ProjectOperation();
        Date start = new Date();
        Date ended = new Date(start.getTime() + 1000); // Add 1 second to the start time
        operation.setEnded(ended);
        assertEquals(ended, operation.getEnded());
    }

    @Test
    public void testIsActive() {
        ProjectOperation operation = new ProjectOperation();
        operation.setActive(true);
        assertTrue(operation.isActive());
    }


    @Test
    public void testIllegalArgumentExceptionInSetIdWithZero() {
        ProjectOperation operation = new ProjectOperation();
        assertThrows(IllegalArgumentException.class, () -> operation.setId(0L));
    }

    @Test
    public void testIllegalArgumentExceptionInSetIdWithNegativeValue() {
        ProjectOperation operation = new ProjectOperation();
        assertThrows(IllegalArgumentException.class, () -> operation.setId(-1L));
    }


    @Test
    public void testNullPointerExceptionInSetProject() {
        ProjectOperation operation = new ProjectOperation();

        assertThrows(NullPointerException.class, () -> operation.setProject(null));
    }

    @Test
    public void testIllegalArgumentExceptionInSetType() {
        ProjectOperation operation = new ProjectOperation();

        assertThrows(IllegalArgumentException.class, () -> operation.setType(null));
    }

    @Test
    public void testIllegalArgumentExceptionInSetEnded() {
        ProjectOperation operation = new ProjectOperation();

        Date start = new Date();
        Date endedBeforeStart = new Date(start.getTime() - 1000);

        operation.setStart(start);

        assertThrows(IllegalArgumentException.class, () -> operation.setEnded(endedBeforeStart));
    }

    @Test
    public void testToString() {
        Project project = new Project();
        Position position = new Position();
        Worker worker = new Worker();
        OperationType type = OperationType.Farbanje;

        Date start = new Date();
        Date ended = new Date(start.getTime() + 1000);

        ProjectOperation operation = new ProjectOperation(1L, project, position, worker, type, start, ended, true);

        String expectedToString = "ProjectOperation{id=1, project=" + project + ", position=" + position + ", worker=" + worker +
                ", type=" + type + ", start=" + start + ", ended=" + ended + ", active=true}";

        assertEquals(expectedToString, operation.toString());
    }
}
