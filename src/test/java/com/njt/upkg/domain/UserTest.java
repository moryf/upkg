package com.njt.upkg.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    @Test
    public void testGetId() {
        User user = new User();
        user.setId(1L);
        assertEquals(1L, user.getId());
    }

    @Test
    public void testGetUsername() {
        User user = new User();
        user.setUsername("john_doe");
        assertEquals("john_doe", user.getUsername());
    }

    @Test
    public void testGetPassword() {
        User user = new User();
        user.setPassword("password123");
        assertEquals("password123", user.getPassword());
    }

    @Test
    public void testGetRole() {
        User user = new User();
        user.setRole(Role.Admin);
        assertEquals(Role.Admin, user.getRole());
    }


    @Test
    public void testIllegalArgumentExceptionInSetIdWithZero() {
        User user = new User();
        assertThrows(IllegalArgumentException.class, () -> user.setId(0L));
    }

    @Test
    public void testIllegalArgumentExceptionInSetIdWithNegativeValue() {
        User user = new User();
        assertThrows(IllegalArgumentException.class, () -> user.setId(-1L));
    }


    @Test
    public void testIllegalArgumentExceptionInSetUsernameWithNull() {
        User user = new User();
        assertThrows(IllegalArgumentException.class, () -> user.setUsername(null));
    }

    @Test
    public void testIllegalArgumentExceptionInSetUsernameWithEmptyString() {
        User user = new User();
        assertThrows(IllegalArgumentException.class, () -> user.setUsername(""));
    }


    @Test
    public void testIllegalArgumentExceptionInSetPasswordWithNull() {
        User user = new User();
        assertThrows(IllegalArgumentException.class, () -> user.setPassword(null));
    }

    @Test
    public void testIllegalArgumentExceptionInSetPasswordWithEmptyString() {
        User user = new User();
        assertThrows(IllegalArgumentException.class, () -> user.setPassword(""));
    }


    @Test
    public void testNullPointerExceptionInSetRole() {
        User user = new User();

        assertThrows(NullPointerException.class, () -> user.setRole(null));
    }

    @Test
    public void testToString() {
        User user = new User(1L, "john_doe", "password123", Role.Admin);

        String expectedToString = "User{id=1, username='john_doe', password='password123', role=Admin}";

        assertEquals(expectedToString, user.toString());
    }
}

