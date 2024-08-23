package com.Task.controller;

import com.Task.service.iTaskInterface.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Home")
public class TaskController {

    @Autowired
    private ITaskService taskService;

    @GetMapping("")
    public String home(Model model){
        model.addAttribute("task", "hola mundo");
        return "Home";
    }

}
