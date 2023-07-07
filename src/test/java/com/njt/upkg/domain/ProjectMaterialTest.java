package com.njt.upkg.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProjectMaterialTest {

    @Test
    public void testGettersAndSetters() {
        ProjectMaterial projectMaterial = new ProjectMaterial();

        projectMaterial.setId(1L);
        assertEquals(1L, projectMaterial.getId());

        Project project = new Project();
        projectMaterial.setProject(project);
        assertEquals(project, projectMaterial.getProject());

        Position position = new Position();
        projectMaterial.setPosition(position);
        assertEquals(position, projectMaterial.getPosition());

        Material material = new Material();
        projectMaterial.setMaterial(material);
        assertEquals(material, projectMaterial.getMaterial());

        projectMaterial.setAmount(10);
        assertEquals(10, projectMaterial.getAmount());
    }

    @Test
    public void testIllegalArgumentExceptionInSetId() {
        ProjectMaterial projectMaterial = new ProjectMaterial();

        assertThrows(IllegalArgumentException.class, () -> projectMaterial.setId(0L));
        assertThrows(IllegalArgumentException.class, () -> projectMaterial.setId(-1L));
    }

    @Test
    public void testNullPointerExceptionInSetProject() {
        ProjectMaterial projectMaterial = new ProjectMaterial();

        assertThrows(NullPointerException.class, () -> projectMaterial.setProject(null));
    }

    @Test
    public void testNullPointerExceptionInSetMaterial() {
        ProjectMaterial projectMaterial = new ProjectMaterial();

        assertThrows(NullPointerException.class, () -> projectMaterial.setMaterial(null));
    }

    @Test
    public void testIllegalArgumentExceptionInSetAmount() {
        ProjectMaterial projectMaterial = new ProjectMaterial();

        assertThrows(IllegalArgumentException.class, () -> projectMaterial.setAmount(0));
        assertThrows(IllegalArgumentException.class, () -> projectMaterial.setAmount(-1));
    }

    @Test
    public void testToString() {
        Project project = new Project();
        Position position = new Position();
        Material material = new Material();

        ProjectMaterial projectMaterial = new ProjectMaterial(1L, project, position, material, 10);

        String expectedToString = "ProjectMaterial{id=1, project=" + project + ", position=" + position +
                ", material=" + material + ", amount=10}";

        assertEquals(expectedToString, projectMaterial.toString());
    }
}
