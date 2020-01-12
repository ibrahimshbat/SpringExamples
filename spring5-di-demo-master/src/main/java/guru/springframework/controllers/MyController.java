package guru.springframework.controllers;

import guru.springframework.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {
    private GreetingService greetingService;

    public MyController(GreetingService greetingService){
        this.greetingService = greetingService;
    }
    public String sayHello(){
        System.out.println("Hello Ibrahim!!");
        return greetingService.sayGreeting();
    }
}
