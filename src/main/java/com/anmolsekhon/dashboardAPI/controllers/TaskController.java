package com.anmolsekhon.dashboardAPI.controllers;

import com.anmolsekhon.dashboardAPI.beans.Task;
import com.anmolsekhon.dashboardAPI.database.DatabaseAccess;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TaskController {

    @Autowired
    protected DatabaseAccess da;

    @GetMapping("/task")
    public String getAllTasks() {
        List<Task> tasks = da.getAllTasks();
        Gson gson = new Gson();

        return gson.toJson(tasks);
    }

    @GetMapping("/task/{id}")
    public String getTaskById(@PathVariable Long id) {
        Gson gson = new Gson();
        try {
            Task task = da.getTaskById(id);
            return gson.toJson(task);
        } catch (IndexOutOfBoundsException exception) {
            System.out.println(exception);
            return "{}";
        }

    }

    @PutMapping("/task")
    public void updateTask(@RequestBody Task task) {
        da.updateTask(task);
    }

    @PostMapping("/task")
    public void addTask(@RequestBody Task task) {
        da.addTask(task);
    }
}
