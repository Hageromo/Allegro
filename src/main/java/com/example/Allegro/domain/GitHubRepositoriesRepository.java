package com.example.Allegro.domain;

import com.example.Allegro.domain.Name.RepositoryName;
import com.example.Allegro.domain.Name.UserName;

import java.util.List;

public interface GitHubRepositoriesRepository {
    List<GitHubRepository> getUserRepositories(UserName user);


    record Language(String languageName, Integer size) {
    }

    List<Language> getRepoLanguages(UserName user, RepositoryName repositoryName);

}
