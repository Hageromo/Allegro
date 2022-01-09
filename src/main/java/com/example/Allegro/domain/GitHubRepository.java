package com.example.Allegro.domain;

import com.example.Allegro.domain.Name.RepositoryName;
import com.example.Allegro.domain.Stars.StarsCount;

import java.util.Objects;

public record GitHubRepository(RepositoryName repositoryName, StarsCount stars) {
    public GitHubRepository {
        Objects.requireNonNull(repositoryName, "Repository name cannot be null");
        Objects.requireNonNull(stars, "Stars count cannot be null");
    }
}
