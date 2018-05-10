package com.wallstreet;

import com.wallstreet.config.AppConfig;
import com.wallstreet.config.AppConfigTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppConfigTest.class})
@SpringBootTest
public class ApplicationRunnerTest {
    @LocalServerPort
    private int port;

    @Test
    public void contextLoads() {
        ApplicationRunner.main(new String[]{});
        TestRestTemplate restTemplate = new TestRestTemplate();
        assertThat(restTemplate.getForObject("http://localhost:" + port + "/",
                String.class)).isNotBlank();
    }
}
