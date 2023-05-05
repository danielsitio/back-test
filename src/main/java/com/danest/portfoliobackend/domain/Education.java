package com.danest.portfoliobackend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "educations")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "education_generator")
    @SequenceGenerator(name = "education_generator", sequenceName = "education_sequence")
    private Long id;

    private String institute;
    private String degree;

    public Long getId() {
        return id;
    }

    public String getInstitute() {
        return institute;
    }

    public String getDegree() {
        return degree;
    }

    public void setInstitute(String institute) {
        this.institute = institute;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

}
