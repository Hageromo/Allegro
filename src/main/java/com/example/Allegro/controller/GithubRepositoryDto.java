package com.example.Allegro.controller;

import com.example.Allegro.domain.GitHubRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GithubRepositoryDto {
    String name;
    int stars;

    public GithubRepositoryDto(String name, int stars) {
        this.name = name;
        this.stars = stars;
    }
    public static GithubRepositoryDto from(GitHubRepository gitHubRepository) {
        return new GithubRepositoryDto(gitHubRepository.repositoryName().value(), gitHubRepository.stars().value());
    }
}
