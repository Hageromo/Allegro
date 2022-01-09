package com.example.Allegro.controller;

import com.example.Allegro.domain.GitHubRepositoriesRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLanguageDto {

    String language;
    int size;

    UserLanguageDto(String language, int size){
        this.language = language;
        this.size = size;
    }

    public static UserLanguageDto from(GitHubRepositoriesRepository.Language gitHubRepository) {
        return new UserLanguageDto(gitHubRepository.languageName(), gitHubRepository.size());
    }

}
