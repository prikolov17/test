package edu.course.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TaskIdTest {

    @Test
    void createsValidId() {
        TaskId id = new TaskId("T-1");

        assertEquals("T-1", id.value());
    }

    @Test
    void rejectsInvalidId() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new TaskId(null)
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> new TaskId(" ")
        );
    }
}