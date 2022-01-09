package com.example.Allegro.domain.Langs;

import com.example.Allegro.domain.GitHubRepositoriesRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record UserLanguagesReportCalculator (){


    public static List<GitHubRepositoriesRepository.Language> calculate(List<GitHubRepositoriesRepository.Language> languagesWithDuplicates){
        Map<String, Integer> langToSizeForUser = languagesWithDuplicates.stream()
                .collect(Collectors.toMap(
                        GitHubRepositoriesRepository.Language::languageName,
                        GitHubRepositoriesRepository.Language::size,
                        Integer::sum
                ));

        return langToSizeForUser.entrySet().stream().map(entry -> new GitHubRepositoriesRepository.Language(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparing(GitHubRepositoriesRepository.Language::size).reversed())
                .collect(Collectors.toList());
    }

}
