package com.example.jpa.controller;

import com.example.jpa.domain.User;
import com.example.jpa.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String main() {
        return "/main";
    }

    @PostMapping("/join")
    public String join(@RequestParam String name, @RequestParam String email) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return "redirect:/";
    }

    @GetMapping("/check-email")
    @ResponseBody
    public boolean checkEmail(@RequestParam String email) {
        return !userRepository.existsByEmail(email); // true = 사용 가능
    }
}
