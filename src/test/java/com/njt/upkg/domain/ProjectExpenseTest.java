package com.njt.upkg.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProjectExpenseTest {

    @Test
    public void testGetId() {
        ProjectExpense projectExpense = new ProjectExpense();
        projectExpense.setId(1L);
        assertEquals(1L, projectExpense.getId());
    }

    @Test
    public void testGetProject() {
        ProjectExpense projectExpense = new ProjectExpense();
        Project project = new Project();
        projectExpense.setProject(project);
        assertEquals(project, projectExpense.getProject());
    }

    @Test
    public void testGetPosition() {
        ProjectExpense projectExpense = new ProjectExpense();
        Position position = new Position();
        projectExpense.setPosition(position);
        assertEquals(position, projectExpense.getPosition());
    }

    @Test
    public void testGetOperation() {
        ProjectExpense projectExpense = new ProjectExpense();
        ProjectOperation operation = new ProjectOperation();
        projectExpense.setOperation(operation);
        assertEquals(operation, projectExpense.getOperation());
    }

    @Test
    public void testGetValue() {
        ProjectExpense projectExpense = new ProjectExpense();
        projectExpense.setValue(100.0f);
        assertEquals(100.0f, projectExpense.getValue(), 0.01);
    }


    @Test
    public void testIllegalArgumentExceptionInSetIdWithZero() {
        ProjectExpense projectExpense = new ProjectExpense();
        assertThrows(IllegalArgumentException.class, () -> projectExpense.setId(0L));
    }

    @Test
    public void testIllegalArgumentExceptionInSetIdWithNegativeValue() {
        ProjectExpense projectExpense = new ProjectExpense();
        assertThrows(IllegalArgumentException.class, () -> projectExpense.setId(-1L));
    }


    @Test
    public void testNullPointerExceptionInSetProject() {
        ProjectExpense projectExpense = new ProjectExpense();

        assertThrows(NullPointerException.class, () -> projectExpense.setProject(null));
    }

    @Test
    public void testIllegalArgumentExceptionInSetValueWithZero() {
        ProjectExpense projectExpense = new ProjectExpense();
        assertThrows(IllegalArgumentException.class, () -> projectExpense.setValue(0.0f));
    }

    @Test
    public void testIllegalArgumentExceptionInSetValueWithNegativeValue() {
        ProjectExpense projectExpense = new ProjectExpense();
        assertThrows(IllegalArgumentException.class, () -> projectExpense.setValue(-1.0f));
    }


    @Test
    public void testToString() {
        Project project = new Project();
        Position position = new Position();
        ProjectOperation operation = new ProjectOperation();

        ProjectExpense projectExpense = new ProjectExpense(1L, project, position, operation, 100.0f);

        String expectedToString = "ProjectExpense{id=1, project=" + project + ", position=" + position +
                ", operation=" + operation + ", value=100.0}";

        assertEquals(expectedToString, projectExpense.toString());
    }
}
