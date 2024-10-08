package com.Task.service.taskService;

import com.Task.entity.Task;
import com.Task.repository.TaskRepository;
import com.Task.service.iTaskInterface.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class Taskservice implements ITaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void destroy(String s) {taskRepository.deleteById(s);}

    @Override
    public List<Task> readAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task readById(String s) {
        return taskRepository.findById(s).orElse(null);
    }

    @Override
    public Task save(Task task) {
        task.setDateCreation(Date.valueOf(LocalDate.now()));
        task.setTimeCreation(Time.valueOf(LocalTime.now()));
        return taskRepository.save(task);
    }
}
