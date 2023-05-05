package com.danest.portfoliobackend.domain;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.danest.portfoliobackend.util.NullOrNotBlank;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_generator")
    @SequenceGenerator(name = "project_generator", sequenceName = "project_sequence")
    private Long id;
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String name;
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String description;
    @NotNull
    @Column(nullable = false)
    private LocalDate realizationDate;
    @NullOrNotBlank
    private String link;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getRealizationDate() {
        return realizationDate;
    }

    public Long getId() {
        return id;
    }

    public String getLink() {
        return link;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRealizationDate(LocalDate realizationDate) {
        this.realizationDate = realizationDate;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
