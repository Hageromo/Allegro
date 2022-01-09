package com.example.Allegro.domain.Stars;

import com.example.Allegro.domain.GitHubRepository;

import java.util.List;

public class UserStarsCalculator {
    public static StarsCount calculate(List<GitHubRepository> userRepositories) {
        return userRepositories.stream()
                .map(GitHubRepository::stars)
                .reduce(StarsCount.ZERO, StarsCount::add);
    }
}
