package ru.netology.task1;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Task1ApplicationTests {
    @Autowired
    private TestRestTemplate restTemplate;
    private static final GenericContainer<?> dev = new GenericContainer<>("devapp").withExposedPorts(8080);
    private static final GenericContainer<?> prod = new GenericContainer<>("prodapp").withExposedPorts(8081);


    @BeforeAll
    public static void setUp() {
        dev.start();
        prod.start();
    }

    @Test
    void contextLoads() {
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + dev.getMappedPort(8080) + "/profile", String.class);
        Assertions.assertEquals(forEntity.getBody(), "Current profile is dev");
        ResponseEntity<String> forEntity2 = restTemplate.getForEntity("http://localhost:" + prod.getMappedPort(8081) + "/profile", String.class);
        Assertions.assertEquals(forEntity2.getBody(), "Current profile is production");
    }
}
