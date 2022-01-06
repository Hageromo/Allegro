package com.example.Allegro.service;

import java.util.List;

public interface ParsingService {

    <T> List<T> parse(String url);

}
