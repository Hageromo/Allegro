package com.example.Allegro.domain;

import com.example.Allegro.domain.Name.UserName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserNameTest {


    @Test
    public void UserName(){
        UserName user = new UserName("User");
    }

    @Test
    public void UserNameNull(){

        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> {
                    UserName userName = new UserName(null);
                }, "User name cannot be null");

        Assertions.assertEquals("User name cannot be null", thrown.getMessage());
    }

    @Test
    public void UserNameEmpty(){

        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> {
                    UserName userName = new UserName("");
                }, "User name cannot be empty or blank");

        Assertions.assertEquals("User name cannot be empty or blank", thrown.getMessage());
    }

    @Test
    public void UserNameBlank(){

        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> {
                    UserName userName = new UserName("  ");
                }, "User name cannot be empty or blank");

        Assertions.assertEquals("User name cannot be empty or blank", thrown.getMessage());
    }

}