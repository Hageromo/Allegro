package com.example.Allegro.domain;

import com.example.Allegro.domain.Langs.UserLanguagesReportCalculator;
import com.example.Allegro.domain.Name.RepositoryName;
import com.example.Allegro.domain.Name.UserName;
import com.example.Allegro.domain.Stars.UserStarsCalculator;
import com.example.Allegro.domain.Stars.UsersStars;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class QueryHandler {
    private final GitHubRepositoriesRepository repository;

    public QueryHandler(GitHubRepositoriesRepository repository) {
        this.repository = repository;
    }

    public List<GitHubRepository> getUserRepositories(UserName user) {
        Objects.requireNonNull(user);

        return repository.getUserRepositories(user);
    }

    public UsersStars getUserStars(UserName user) {
        Objects.requireNonNull(user);

        return new UsersStars(user, UserStarsCalculator.calculate(repository.getUserRepositories(user)));
    }

    public List<GitHubRepositoriesRepository.Language> getUserLanguageReport(UserName user) {

        List<GitHubRepositoriesRepository.Language> languagesWithDuplicates = repository.getUserRepositories(user).stream()
                .flatMap(repo -> repository.getRepoLanguages(user, repo.repositoryName()).stream())
                .collect(Collectors.toList());


       return UserLanguagesReportCalculator.calculate(languagesWithDuplicates);
    }
}
