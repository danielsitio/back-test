package com.danest.portfoliobackend.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface ProjectRepository extends CrudRepository<Project, Long> {
}
