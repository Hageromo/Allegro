package com.example.Allegro.controller;

import com.example.Allegro.domain.Stars.UsersStars;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserStarsDto {

    String user;
    int stars;

    public UserStarsDto(String user, int stars) {
        this.user = user;
        this.stars = stars;
    }
    public static UserStarsDto from(UsersStars usersStars) {
        return new UserStarsDto(usersStars.user().user(), usersStars.stars().value());
    }
}
