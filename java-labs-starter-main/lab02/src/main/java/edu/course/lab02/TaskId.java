package edu.course.lab02;

public record TaskId(String value) {

    public TaskId {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(
                    "TaskId value cannot be null or blank"
            );
        }
    }
}