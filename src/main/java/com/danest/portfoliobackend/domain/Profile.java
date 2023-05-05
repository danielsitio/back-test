package com.danest.portfoliobackend.domain;

import com.danest.portfoliobackend.util.NullOrNotBlank;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Embeddable
public class Profile {
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String name;
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String lastName;
    @NotNull
    @NotBlank
    @Column(nullable = false)
    private String description;
    @NullOrNotBlank
    private String picture;

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDescription() {
        return description;
    }

    public String getPicture() {
        return picture;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
}
