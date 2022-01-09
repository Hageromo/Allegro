package com.example.Allegro.domain;

import com.example.Allegro.domain.Name.RepositoryName;
import com.example.Allegro.domain.Stars.StarsCount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GitHubRepositoryTest {
    

    @Test
    public void GitHubRepository(){

        GitHubRepository gitHubRepository = new GitHubRepository(new RepositoryName("repo1"), new StarsCount(0));
    }

    @Test
    public void GitHubRepositoryNullName(){
        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> {
                    GitHubRepository gitHubRepository = new GitHubRepository(null, new StarsCount(0));
                }, "Repository name cannot be null");

        Assertions.assertEquals("Repository name cannot be null", thrown.getMessage());
    }


    @Test
    public void GitHubRepositoryNullStars(){
        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> {
                    GitHubRepository gitHubRepository = new GitHubRepository(new RepositoryName("repo1"), null);
                }, "Stars count cannot be null");

        Assertions.assertEquals("Stars count cannot be null", thrown.getMessage());
    }


}