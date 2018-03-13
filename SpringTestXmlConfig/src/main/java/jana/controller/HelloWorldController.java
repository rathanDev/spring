package jana.controller;

import jana.model.Hello;
import jana.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HelloWorldController {

    @Autowired
    HelloWorldService helloWorldService;

    @RequestMapping("/hello")
    public String hello(Model model) {
        List<Hello> hellos = helloWorldService.get();
        Hello hello = hellos.get(0);
        String h = hello.getH();
        model.addAttribute("greeting", h);
        return "helloworld";
    }

}