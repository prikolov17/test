package edu.course.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ProjectTaskTest {

    @Test
    void createsValidTask() {
        ProjectTask task = new ProjectTask(
                "T-1",
                "Implement login",
                TaskStatus.TODO,
                8
        );

        assertEquals("T-1", task.getId());
        assertEquals("Implement login", task.getTitle());
        assertEquals(TaskStatus.TODO, task.getStatus());
        assertEquals(8, task.getEstimatedHours());

        assertFalse(task.isCompleted());
    }

    @Test
    void changesStatusThroughChangeStatus() {
        ProjectTask task = new ProjectTask(
                "T-1",
                "Implement login",
                TaskStatus.TODO,
                8
        );

        task.changeStatus(TaskStatus.DONE);

        assertEquals(TaskStatus.DONE, task.getStatus());
        assertTrue(task.isCompleted());
    }

    @Test
    void rejectsNullId() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new ProjectTask(
                        null,
                        "Task",
                        TaskStatus.TODO,
                        1
                )
        );
    }

    @Test
    void rejectsBlankId() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new ProjectTask(
                        "   ",
                        "Task",
                        TaskStatus.TODO,
                        1
                )
        );
    }

    @Test
    void rejectsNullTitle() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new ProjectTask(
                        "T-1",
                        null,
                        TaskStatus.TODO,
                        1
                )
        );
    }

    @Test
    void rejectsBlankTitle() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new ProjectTask(
                        "T-1",
                        "   ",
                        TaskStatus.TODO,
                        1
                )
        );
    }

    @Test
    void rejectsNullStatus() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new ProjectTask(
                        "T-1",
                        "Task",
                        null,
                        1
                )
        );
    }

    @Test
    void rejectsNonPositiveEstimatedHours() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new ProjectTask(
                        "T-1",
                        "Task",
                        TaskStatus.TODO,
                        0
                )
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> new ProjectTask(
                        "T-1",
                        "Task",
                        TaskStatus.TODO,
                        -1
                )
        );
    }

    @Test
    void rejectsNullStatusWhenChangingStatus() {
        ProjectTask task = new ProjectTask(
                "T-1",
                "Task",
                TaskStatus.TODO,
                1
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> task.changeStatus(null)
        );
    }

    @Test
    void increasesEstimatedHours() {
        ProjectTask task = new ProjectTask(
                "T-1",
                "Task",
                TaskStatus.TODO,
                8
        );

        task.increaseEstimatedHours(4);

        assertEquals(12, task.getEstimatedHours());
    }

    @Test
    void rejectsNonPositiveAdditionalHours() {
        ProjectTask task = new ProjectTask(
                "T-1",
                "Task",
                TaskStatus.TODO,
                8
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> task.increaseEstimatedHours(0)
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> task.increaseEstimatedHours(-2)
        );
    }
}
