package mds.container2;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.core.DockerClientBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DockerController {

    DockerClient dockerClient = DockerClientBuilder.getInstance("tcp://localhost:2375").build();

    public List<Container> listContainers(){
        List<Container> containers = dockerClient.listContainersCmd().exec();
        return containers;
    }

    @GetMapping(path = "/dockerlist")
    public String dockerlist(Model model){
        model.addAttribute("listContainers", listContainers());
        return "dockerlist";
    }

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/roger")
    public String roger(){return "roger";}
}
