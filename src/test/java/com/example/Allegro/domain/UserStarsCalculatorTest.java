package com.example.Allegro.domain;

import com.example.Allegro.domain.Name.RepositoryName;
import com.example.Allegro.domain.Stars.StarsCount;
import com.example.Allegro.domain.Stars.UserStarsCalculator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserStarsCalculatorTest {
    @Test
    public void UserStarsCalculator(){

        //Given
        List<GitHubRepository> userRepositories = new ArrayList<>();
        GitHubRepository gitHubRepository = new GitHubRepository(new RepositoryName("1"),new StarsCount(2));
        GitHubRepository gitHubRepository2 = new GitHubRepository(new RepositoryName("2"),new StarsCount(2));
        userRepositories.add(gitHubRepository);
        userRepositories.add(gitHubRepository2);

        //When
        StarsCount result = UserStarsCalculator.calculate(userRepositories);

        //Then
        assertThat(result).isEqualTo(new StarsCount(4));

    }

    @Test
    public void UserStarsCalculatorEmpty(){

        //Given
        List<GitHubRepository> userRepositories = new ArrayList<>();

        //When
        StarsCount result = UserStarsCalculator.calculate(userRepositories);

        //Then
        assertThat(result).isEqualTo(StarsCount.ZERO);
    }

    @Test
    public void UserStarsCalculatorOneElement() {

        //Given
        List<GitHubRepository> userRepositories = new ArrayList<>();
        GitHubRepository gitHubRepository = new GitHubRepository(new RepositoryName("1"), new StarsCount(2));
        userRepositories.add(gitHubRepository);

        //When
        StarsCount result = UserStarsCalculator.calculate(userRepositories);

        //Then
        assertThat(result).isEqualTo(new StarsCount(2));
    }

}