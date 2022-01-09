package com.example.Allegro;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import wiremock.org.apache.http.HttpResponse;
import wiremock.org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = AllegroApplication.class)
public class GitHubConectionTest {

//    @Test
//    public void checkStatusCodeForAll() throws IOException {
//
//        // Given
//        HttpUriRequest request = new HttpGet( "http://localhost:8080/repos/Hageromo");
//
//        // When
//        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
//
//        // Then
//        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
//    }
//
//    @Test
//    public void checkStatusCodeForStars() throws IOException {
//
//        // Given
//        HttpUriRequest request = new HttpGet( "http://localhost:8080/repos/Hageromo/stars");
//
//        // When
//        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
//
//        // Then
//        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
//    }
//
//    @Test
//    public void checkStatusCodeForLanguages() throws IOException {
//
//        // Given
//        HttpUriRequest request = new HttpGet( "http://localhost:8080/repos/Hageromo/languages");
//
//        // When
//        HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
//
//        // Then
//        assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
//    }

}
