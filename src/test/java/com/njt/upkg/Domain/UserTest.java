package com.njt.upkg.Domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testGettersAndSetters() {
        User user = new User();

        user.setId(1);
        assertEquals(1, user.getId());

        user.setUsername("john_doe");
        assertEquals("john_doe", user.getUsername());

        user.setPassword("password123");
        assertEquals("password123", user.getPassword());

        user.setRole(Role.Admin);
        assertEquals(Role.Admin, user.getRole());
    }

    @Test
    public void testIllegalArgumentExceptionInSetUsername() {
        User user = new User();

        assertThrows(IllegalArgumentException.class, () -> user.setUsername(null));
        assertThrows(IllegalArgumentException.class, () -> user.setUsername(""));
    }

    @Test
    public void testIllegalArgumentExceptionInSetPassword() {
        User user = new User();

        assertThrows(IllegalArgumentException.class, () -> user.setPassword(null));
        assertThrows(IllegalArgumentException.class, () -> user.setPassword(""));
    }

    @Test
    public void testNullPointerExceptionInSetRole() {
        User user = new User();

        assertThrows(NullPointerException.class, () -> user.setRole(null));
    }

    @Test
    public void testToString() {
        User user = new User(1, "john_doe", "password123", Role.Admin);

        String expectedToString = "User{id=1, username='john_doe', password='password123', role=Admin}";

        assertEquals(expectedToString, user.toString());
    }
}

