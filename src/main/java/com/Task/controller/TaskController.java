package com.Task.controller;

import com.Task.entity.Task;
import com.Task.service.iTaskInterface.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Home")
public class TaskController {

    @Autowired
    private ITaskService taskService;

    @GetMapping
    public String home(Model model){
        List<Task> tasks = taskService.readAll();
        model.addAttribute("task", tasks);
        return "Home";
    }

    @GetMapping("nueva")
    public String formulario(Model model){
        model.addAttribute("task", new Task());
        return "form";
    }

}
