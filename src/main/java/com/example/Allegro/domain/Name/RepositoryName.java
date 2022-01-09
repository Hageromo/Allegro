package com.example.Allegro.domain.Name;

public record RepositoryName(String value) {
    public RepositoryName{
        if (value == null) {
            throw new RuntimeException("Repository name cannot be null");
        } else if (value.isEmpty() || value.isBlank()) {
            throw new RuntimeException("Repository name cannot be empty or blank");
        }
    }
}
