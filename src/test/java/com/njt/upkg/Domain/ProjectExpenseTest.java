package com.njt.upkg.Domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProjectExpenseTest {

    @Test
    public void testGettersAndSetters() {
        ProjectExpense projectExpense = new ProjectExpense();

        projectExpense.setId(1);
        assertEquals(1, projectExpense.getId());

        Project project = new Project();
        projectExpense.setProject(project);
        assertEquals(project, projectExpense.getProject());

        Position position = new Position();
        projectExpense.setPosition(position);
        assertEquals(position, projectExpense.getPosition());

        ProjectOperation operation = new ProjectOperation();
        projectExpense.setOperation(operation);
        assertEquals(operation, projectExpense.getOperation());

        projectExpense.setValue(100.0f);
        assertEquals(100.0f, projectExpense.getValue(), 0.01);
    }

    @Test
    public void testIllegalArgumentExceptionInSetId() {
        ProjectExpense projectExpense = new ProjectExpense();

        assertThrows(IllegalArgumentException.class, () -> projectExpense.setId(0));
        assertThrows(IllegalArgumentException.class, () -> projectExpense.setId(-1));
    }

    @Test
    public void testNullPointerExceptionInSetProject() {
        ProjectExpense projectExpense = new ProjectExpense();

        assertThrows(NullPointerException.class, () -> projectExpense.setProject(null));
    }

    @Test
    public void testIllegalArgumentExceptionInSetValue() {
        ProjectExpense projectExpense = new ProjectExpense();

        assertThrows(IllegalArgumentException.class, () -> projectExpense.setValue(0.0f));
        assertThrows(IllegalArgumentException.class, () -> projectExpense.setValue(-1.0f));
    }

    @Test
    public void testToString() {
        Project project = new Project();
        Position position = new Position();
        ProjectOperation operation = new ProjectOperation();

        ProjectExpense projectExpense = new ProjectExpense(1, project, position, operation, 100.0f);

        String expectedToString = "ProjectExpense{id=1, project=" + project + ", position=" + position +
                ", operation=" + operation + ", value=100.0}";

        assertEquals(expectedToString, projectExpense.toString());
    }
}
