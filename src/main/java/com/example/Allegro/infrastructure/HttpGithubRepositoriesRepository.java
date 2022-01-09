package com.example.Allegro.infrastructure;

import com.example.Allegro.domain.GitHubRepositoriesRepository;
import com.example.Allegro.domain.GitHubRepository;
import com.example.Allegro.domain.Name.RepositoryName;
import com.example.Allegro.domain.Name.UserName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class HttpGithubRepositoriesRepository implements GitHubRepositoriesRepository {
    private static final MediaType GITHUB_APPLICATION_JSON = MediaType.parseMediaType("application/vnd.github.v3+json");
    private final RestTemplate restTemplate;
    private final String githubUrl;
    //private final String token;

    public HttpGithubRepositoriesRepository(RestTemplate restTemplate, @Value("${http.github.url}") String githubUrl) {
        this.restTemplate = restTemplate;
        this.githubUrl = githubUrl;
        //this.token = token;
    }

    @Override
    public List<GitHubRepository> getUserRepositories(UserName user) {
        String url = String.format("%s/users/%s/repos",githubUrl, user.user());

        ParameterizedTypeReference<List<GithubRepositoryResponse>> responseType =
                new ParameterizedTypeReference<>() {};

        RequestEntity<Void> request = RequestEntity.get(url)
                //.header("Authorization", String.format("token %s", token))
                .accept(GITHUB_APPLICATION_JSON)
                .build();

        return Objects.requireNonNull(restTemplate.exchange(request, responseType).getBody()).stream()
                .map(GithubRepositoryResponse::toDomain)
                .collect(Collectors.toList());

    }


    @Override
    public List<Language> getRepoLanguages(UserName name, RepositoryName repositoryName) {

        String url = String.format("%s/repos/%s/%s/languages",githubUrl, name.user(), repositoryName.value());

        ParameterizedTypeReference<Map<String, Integer>> responseType =
                new ParameterizedTypeReference<Map<String, Integer>>() {};

        RequestEntity<Void> request = RequestEntity.get(url)
                //.header("Authorization", String.format("token %s", token))
                .accept(GITHUB_APPLICATION_JSON)
                .build();


        return restTemplate.exchange(request, responseType).getBody()
                .entrySet()
                .stream().map(entry -> new Language(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

}

