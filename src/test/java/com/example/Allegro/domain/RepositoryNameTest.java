package com.example.Allegro.domain;

import com.example.Allegro.domain.Name.RepositoryName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryNameTest {


    @Test
    public void RepositoryName(){

        RepositoryName repositoryName = new RepositoryName("user");
    }

    @Test
    public void RepositoryNameNullName(){

        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> {
                    RepositoryName repositoryName = new RepositoryName(null);
                }, "Repository name cannot be null");

        Assertions.assertEquals("Repository name cannot be null", thrown.getMessage());
    }

    @Test
    public void RepositoryNameEmptyName(){

        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> {
                    RepositoryName repositoryName = new RepositoryName("");
                }, "Repository name cannot be empty");

        Assertions.assertEquals("Repository name cannot be empty or blank", thrown.getMessage());
    }

    @Test
    public void RepositoryNameBlankName(){

        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> {
                    RepositoryName repositoryName = new RepositoryName("     ");
                }, "Repository name cannot be blank");

        Assertions.assertEquals("Repository name cannot be empty or blank", thrown.getMessage());
    }
}