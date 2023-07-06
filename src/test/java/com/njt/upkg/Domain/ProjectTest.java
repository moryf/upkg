package com.njt.upkg.Domain;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class ProjectTest {

    @Test
    public void testGettersAndSetters() {
        Project project = new Project();

        project.setId(1L);
        assertEquals(1L, project.getId());

        project.setName("Project ABC");
        assertEquals("Project ABC", project.getName());

        Date startDate = new Date();
        project.setStart(startDate);
        assertEquals(startDate, project.getStart());

        Date deadline = new Date();
        project.setDeadline(deadline);
        assertEquals(deadline, project.getDeadline());

        Buyer buyer = new Buyer();
        project.setBuyer(buyer);
        assertEquals(buyer, project.getBuyer());

        project.setValue(1000.0f);
        assertEquals(1000.0f, project.getValue());

        User createdBy = new User();
        project.setCreatedBy(createdBy);
        assertEquals(createdBy, project.getCreatedBy());

        project.setState(ProjectState.Projektovanje);
        assertEquals(ProjectState.Projektovanje, project.getState());
    }

    @Test
    public void testIllegalArgumentExceptionInSetId() {
        Project project = new Project();

        assertThrows(IllegalArgumentException.class, () -> project.setId(0L));
        assertThrows(IllegalArgumentException.class, () -> project.setId(-1L));
    }
    @Test
    public void testIllegalArgumentExceptionInSetName() {
        Project project = new Project();

        assertThrows(IllegalArgumentException.class, () -> project.setName(null));
        assertThrows(IllegalArgumentException.class, () -> project.setName(""));
    }

    @Test
    public void testNullPointerExceptionInSetDeadline() {
        Project project = new Project();

        assertThrows(NullPointerException.class, () -> project.setDeadline(null));
    }

    @Test
    public void testNullPointerExceptionInSetBuyer() {
        Project project = new Project();

        assertThrows(NullPointerException.class, () -> project.setBuyer(null));
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
