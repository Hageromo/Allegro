package com.example.Allegro.domain;

import java.util.List;

public interface ParsingService {

    <T> List<T> parse(String url);

}
