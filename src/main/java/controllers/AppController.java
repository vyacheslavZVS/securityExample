package controllers;

import lombok.AllArgsConstructor;
import model.Applicaton;
import model.services.AppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/apps")
@AllArgsConstructor
public class AppController {

    private AppService service;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome to the unprotected page";
    }

    @GetMapping("/all-app")
    public List<Applicaton> allApplication(){
        return service.allApplicatons();
    }

    @GetMapping("/{id}")
    public Applicaton applicatonById(@PathVariable int id) {
        return service.applicatonById(id);
    }

    @GetMapping("/error")
    public String err(){
        return "Welcome to the ERROR";
    }

}
