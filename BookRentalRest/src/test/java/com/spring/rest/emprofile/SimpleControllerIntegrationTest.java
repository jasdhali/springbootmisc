package com.spring.rest.emprofile;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.rest.domain.Position;
import com.spring.rest.domain.Stock;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SimpleControllerIntegrationTest {
    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    public void createClient() {
        ResponseEntity<Position> responseEntity =
            restTemplate.postForEntity("/buy", new Position(new Stock("Foo",""),20), Position.class);
        String client = responseEntity.getBody().toString();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Foo", client);
    }
}