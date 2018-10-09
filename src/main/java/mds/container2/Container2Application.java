package mds.container2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Container2Application {

    @RequestMapping("/")
    public String home(){
        return "Hello docker";
    }

    @RequestMapping("/dockerlist")
    public String dockerlist(){ return "dockerlist";}

    public static void main(String[] args) {
        SpringApplication.run(Container2Application.class, args);
    }
}
