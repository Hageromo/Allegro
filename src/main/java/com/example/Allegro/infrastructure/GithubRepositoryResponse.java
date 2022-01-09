package com.example.Allegro.infrastructure;

import com.example.Allegro.domain.GitHubRepository;
import com.example.Allegro.domain.Name.RepositoryName;
import com.example.Allegro.domain.Stars.StarsCount;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GithubRepositoryResponse {
    @JsonProperty("name")       //the name of the repository
    private String name;
    @JsonProperty("stargazers_count")       //number of repository stars
    private Integer stargazers_count;

    public GitHubRepository toDomain() {
        return new GitHubRepository(new RepositoryName(name), new StarsCount(stargazers_count));
    }
}