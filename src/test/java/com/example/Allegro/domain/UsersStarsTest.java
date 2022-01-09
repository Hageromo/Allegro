package com.example.Allegro.domain;

import com.example.Allegro.domain.Name.UserName;
import com.example.Allegro.domain.Stars.StarsCount;
import com.example.Allegro.domain.Stars.UsersStars;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsersStarsTest {


    @Test
    public void UsersStars(){
        UsersStars usersStars = new UsersStars(new UserName("user"), new StarsCount(3));
    }

    @Test
    public void UsersStarsNameNull(){

        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> {
                    UsersStars usersStars = new UsersStars(null, new StarsCount(3));
                }, "User name cannot be null");

        Assertions.assertEquals("User name cannot be null", thrown.getMessage());
    }

    @Test
    public void UsersStarsStarsNull(){

        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> {
                    UsersStars usersStars = new UsersStars(new UserName("user"), null);
                }, "Stars count cannot be null");

        Assertions.assertEquals("Stars count cannot be null", thrown.getMessage());
    }

}