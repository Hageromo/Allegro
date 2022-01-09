package com.example.Allegro.domain.Stars;

import com.example.Allegro.domain.Name.UserName;

import java.util.Objects;

public record UsersStars(UserName user, StarsCount stars) {
    public UsersStars {
        Objects.requireNonNull(stars, "Stars count cannot be null");
        Objects.requireNonNull(user, "User name cannot be null");
    }
}
