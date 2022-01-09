package com.example.Allegro.controller;

import com.example.Allegro.domain.Name.UserName;
import com.example.Allegro.domain.QueryHandler;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/repos")
@AllArgsConstructor
public class MainController {
    private final QueryHandler queryHandler;

    @GetMapping("/{user}")
    public List<GithubRepositoryDto> getRepos(@PathVariable String user) {
        UserName userName = new UserName(user);

        final List<GithubRepositoryDto> collect = queryHandler.getUserRepositories(userName).stream()
                .map(GithubRepositoryDto::from)
                .collect(Collectors.toList());

        return collect;
    }


    @GetMapping("/{user}/stars")
    public UserStarsDto getStars(@PathVariable String user) {
        UserName userName = new UserName(user);

        return UserStarsDto.from(queryHandler.getUserStars(userName));
    }

    @GetMapping("/{user}/repos")
    public List<UserLanguageDto> getLanguages(@PathVariable String user) {
        UserName userName = new UserName(user);

        final List<UserLanguageDto> collect = queryHandler.getUserLanguageReport(userName).stream()
                .map(UserLanguageDto::from)
                .collect(Collectors.toList());

        return collect;
    }
}
