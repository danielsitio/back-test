package com.danest.portfoliobackend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danest.portfoliobackend.domain.Project;
import com.danest.portfoliobackend.domain.ProjectRepository;

@RestController
@RequestMapping("api/projects")
@CrossOrigin
public class ProjectController {

    private final ProjectRepository projectRepository;

    ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping
    Iterable<Project> getAll() {
        return this.projectRepository.findAll();
    }

    @PostMapping
    void add() {
        this.projectRepository.save(null);
    }

}
