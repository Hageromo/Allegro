package com.example.Allegro;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class GitHubConectionTest {

    @Test
    public void checkStatusCodeForAll() throws IOException {

        // Given
        HttpUriRequest request = new HttpGet( "http://localhost:8080/repos/Hageromo");

        // When
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        // Then
        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));

    }

    @Test
    public void checkStatusCodeForStars() throws IOException {

        // Given
        HttpUriRequest request = new HttpGet( "http://localhost:8080/repos/Hageromo/stars");

        // When
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        // Then
        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

    @Test
    public void checkStatusCodeForLanguages() throws IOException {

        // Given
        HttpUriRequest request = new HttpGet( "http://localhost:8080/repos/Hageromo/languages");

        // When
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

        // Then
        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
    }

}
