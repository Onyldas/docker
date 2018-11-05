package mds.container2;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.core.DockerClientBuilder;
import org.apache.commons.lang.SystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class DockerController {

    //final String localDockerHost = SystemUtils.IS_OS_WINDOWS ? "tcp://localhost:2375" : "unix:///var/run/docker.sock";

    DockerClient dockerClient = DockerClientBuilder.getInstance("tcp://localhost:2375").build();

    public List<Container> listContainers(){
        List<Container> containers = dockerClient.listContainersCmd().exec();
        return containers;
    }

    public void createContainer(String image){
        CreateContainerResponse container = dockerClient.createContainerCmd(image).exec();
        dockerClient.startContainerCmd(container.getId()).exec();
    }

    @GetMapping(path = "/dockerlist")
    public String dockerlist(Model model){
        model.addAttribute("listContainers", listContainers());
        return "dockerlist";
    }
    @PostMapping(path = "/dockerlist")
    public String addContainer(@RequestParam String nom, Model model){
        createContainer(nom);
        model.addAttribute("listContainers", listContainers());
        model.addAttribute("nom",nom);
        return "dockerlist";
    }

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/roger")
    public String roger(){return "roger";}
}
