package com.example.projectmanagmenttool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/taskManagement")
public class TaskManagementController {


    @GetMapping
    public String showIndexPage(Model model){

        return "task-managment";
    }

}
