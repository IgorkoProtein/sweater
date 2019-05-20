package com.example.sweater.controller;

import com.example.sweater.domain.Map;
import com.example.sweater.domain.User;
import com.example.sweater.repos.MapsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @Autowired
    private MapsRepo mapsRepo;

    @GetMapping("/")
    public String greeting(java.util.Map model) {
        return "greeting";
    }

    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String filter, Model model) {
        Iterable<Map> maps = mapsRepo.findAll();

        if (filter != null && !filter.isEmpty()) {
            maps = mapsRepo.findByDescription(filter);
        } else {
            maps = mapsRepo.findAll();
        }

        model.addAttribute("maps", maps);
        model.addAttribute("filter", filter);

        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String x,
            @RequestParam String y,
            @RequestParam String description, java.util.Map model
    ) {
        Map map = new Map(x, y, user, description);

        mapsRepo.save(map);

        Iterable<Map> maps = mapsRepo.findAll();

        model.put("maps", maps);

        return "main";
    }
}
