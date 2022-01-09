package com.example.Allegro.domain.Name;

import java.util.Objects;

public record UserName(String user) {
    public UserName {
        Objects.requireNonNull(user, "User name cannot be null");
        if(user.isEmpty() || user.isBlank()){
            throw new RuntimeException("User name cannot be empty or blank");
        }
    }
}
