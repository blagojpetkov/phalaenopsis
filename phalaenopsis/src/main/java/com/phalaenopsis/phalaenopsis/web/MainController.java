package com.phalaenopsis.phalaenopsis.web;

import com.phalaenopsis.phalaenopsis.domain.Topic;
import com.phalaenopsis.phalaenopsis.service.TopicService;
import com.phalaenopsis.phalaenopsis.service.UserService;
import org.hibernate.annotations.Parameter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Controller
public class MainController {
    private final UserService userService;
    private final TopicService topicService;

    public MainController(UserService userService, TopicService topicService) {
        this.userService = userService;
        this.topicService = topicService;
    }

    @GetMapping("/")
    public String getHomePage(){
        return "index";
    }


    @PostMapping("/register")
    public String registerUser(String username, String password, String repeatPassword, String name, String surname){
        if(!Objects.equals(username, "") && password.equals(repeatPassword) && userService.findByUsername(username) == null)
            userService.create(username, password, "User", name, surname);
        return "login";
    }


    @GetMapping("/login.html")
    public String login(String error){
        return "login";
    }


    @GetMapping("/register.html")
    public String register(){
        return "register";
    }

    @GetMapping("/aboutus.html")
    public String aboutus(){
        return "aboutus";
    }


    @GetMapping("/certificate.html")
    public String certificate(){
        return "certificate";
    }

    @GetMapping("/certification.html")
    public String certification(){
        return "certification";
    }


    @GetMapping("/flowers.html")
    public String flowers(Model model){
        model.addAttribute("a5", true);
        return "flowers";
    }

    @GetMapping("/index.html")
    public String index(Model model){
        model.addAttribute("a1", true);
        return "index";
    }


    @GetMapping("/leaves.html")
    public String leaves(Model model){
        model.addAttribute("a3", true);
        return "leaves";
    }

    @GetMapping("/roots.html")
    public String roots(Model model){
        model.addAttribute("a2", true);
        return "roots";
    }


    @GetMapping("/roots_air.html")
    public String roots_air(Model model){
        model.addAttribute("a2", true);
        return "roots_air";
    }

    @GetMapping("/roots_black.html")
    public String roots_black(Model model){
        model.addAttribute("a2", true);
        return "roots_black";
    }


    @GetMapping("/roots_brown.html")
    public String roots_brown(Model model){
        model.addAttribute("a2", true);
        return "roots_brown";
    }

    @GetMapping("/roots_green.html")
    public String roots_green(Model model){
        model.addAttribute("a2", true);
        return "roots_green";
    }


    @GetMapping("/roots_white.html")
    public String roots_white(Model model){
        model.addAttribute("a2", true);
        return "roots_white";
    }

    @GetMapping("/roots_yellow.html")
    public String roots_yellow(Model model){
        model.addAttribute("a2", true);
        return "roots_yellow";
    }


    @GetMapping("/stem.html")
    public String stem(Model model){
        model.addAttribute("a4", true);
        return "stem";
    }

    @PostMapping("/search")
    public String search(@RequestParam String searchString, Model model){
        List<Topic> topics = topicService.getTopicsWithKeyword(searchString);
        model.addAttribute("topics", topics);
        return "search";
    }

    @PostMapping("/certification")
    public String test_certification(@RequestParam String question1,
                                     @RequestParam String question2,
                                     @RequestParam String question3,
                                     @RequestParam String question4,
                                     @RequestParam String question5,
                                     @RequestParam String question6
                                     ){

        if(question1.equals("2") || question2.equals("1") || question3.equals("2") ||
        question4.equals("1") || question5.equals("1") || question6.equals("2")){
            return "certification_passed";
        }

        return "redirect:/certification.html?error=true";
    }


}
