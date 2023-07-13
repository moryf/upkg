package com.njt.upkg.domain;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class ProjectTest {

    @Test
    public void testGetId() {
        Project project = new Project();
        project.setId(1L);
        assertEquals(1L, project.getId());
    }

    @Test
    public void testGetName() {
        Project project = new Project();
        project.setName("Project ABC");
        assertEquals("Project ABC", project.getName());
    }

    @Test
    public void testGetStart() {
        Project project = new Project();
        Date startDate = new Date();
        project.setStart(startDate);
        assertEquals(startDate, project.getStart());
    }

    @Test
    public void testGetDeadline() {
        Project project = new Project();
        Date deadline = new Date();
        project.setDeadline(deadline);
        assertEquals(deadline, project.getDeadline());
    }

    @Test
    public void testGetBuyer() {
        Project project = new Project();
        Buyer buyer = new Buyer();
        project.setBuyer(buyer);
        assertEquals(buyer, project.getBuyer());
    }

    @Test
    public void testGetValue() {
        Project project = new Project();
        project.setValue(1000.0f);
        assertEquals(1000.0f, project.getValue());
    }

    @Test
    public void testGetCreatedBy() {
        Project project = new Project();
        User createdBy = new User();
        project.setCreatedBy(createdBy);
        assertEquals(createdBy, project.getCreatedBy());
    }

    @Test
    public void testGetState() {
        Project project = new Project();
        project.setState(ProjectState.Projektovanje);
        assertEquals(ProjectState.Projektovanje, project.getState());
    }


    @Test
    public void testIllegalArgumentExceptionInSetIdWithZero() {
        Project project = new Project();
        assertThrows(IllegalArgumentException.class, () -> project.setId(0L));
    }

    @Test
    public void testIllegalArgumentExceptionInSetIdWithNegativeValue() {
        Project project = new Project();
        assertThrows(IllegalArgumentException.class, () -> project.setId(-1L));
    }

    @Test
    public void testIllegalArgumentExceptionInSetNameWithNull() {
        Project project = new Project();
        assertThrows(IllegalArgumentException.class, () -> project.setName(null));
    }

    @Test
    public void testIllegalArgumentExceptionInSetNameWithEmptyString() {
        Project project = new Project();
        assertThrows(IllegalArgumentException.class, () -> project.setName(""));
    }


    @Test
    public void testNullPointerExceptionInSetDeadline() {
        Project project = new Project();

        assertThrows(NullPointerException.class, () -> project.setDeadline(null));
    }


    @Test
    public void testIllegalArgumentExceptionInSetValue() {
        Project project = new Project();

        assertThrows(IllegalArgumentException.class, () -> project.setValue(-1000.0f));
    }

    @Test
    public void testNullPointerExceptionInSetState() {
        Project project = new Project();

        assertThrows(NullPointerException.class, () -> project.setState(null));
    }

    @Test
    public void testToString() {
        Buyer buyer = new Buyer();
        User createdBy = new User();

        Project project = new Project(1L, "Project ABC", new Date(), new Date(), buyer, 1000.0f, createdBy, ProjectState.Projektovanje);

        String expectedToString = "Project{id=1, name='Project ABC', deadline=" + project.getDeadline() +
                ", buyer=" + buyer + ", value=1000.0, createdBy=" + createdBy + ", state=Projektovanje}";

        assertEquals(expectedToString, project.toString());
    }
}
