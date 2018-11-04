package mds.container2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;


@Configuration
@SpringBootApplication
@RestController
public class Container2Application {

    public static void main(String[] args) {
        SpringApplication.run(Container2Application.class, args);
    }
}
