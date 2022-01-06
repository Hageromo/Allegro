package com.example.Allegro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class JSONParisnService implements ParsingService{

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public <T> List parse(String url) {

        return restTemplate.getForObject(url, List.class);
    }

}
