package com.Task.controller;

import com.Task.entity.Task;
import com.Task.service.iTaskInterface.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class TaskController {

    @Autowired
    private ITaskService taskService;

    @GetMapping("/Home")
    public String taskAll(Model model){
        model.addAttribute("tasks", taskService.readAll());
        return "Home";
    }

    @GetMapping("/save")
    public String saveTask(Model model){
        model.addAttribute("task", new Task());
        return "form";
    }

    @PostMapping("/save/create")
    public String createTask(@ModelAttribute Task task){
        taskService.save(task);
        return "redirect:/Home";
    }

    @GetMapping("/edit/{id}")
    public String editTask(@PathVariable String id, Model model){
        model.addAttribute("task", taskService.readById(id));
        return "form";
    }

    @PostMapping("/destroy/{id}")
    public String updateTask(@PathVariable String id, Model model){

        taskService.destroy(id);
        return "redirect:/Home";
    }

}
