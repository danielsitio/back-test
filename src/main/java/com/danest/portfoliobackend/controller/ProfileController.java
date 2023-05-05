package com.danest.portfoliobackend.controller;

import java.nio.file.Path;

import org.springframework.core.io.PathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.ServletContextResource;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.danest.portfoliobackend.domain.UserRepository;
import com.danest.portfoliobackend.service.StorageService;

import jakarta.servlet.ServletContext;

@RestController
@CrossOrigin
public class ProfileController {

    private final StorageService storageService;
    private final UserRepository userRepository;

    ProfileController(StorageService storageService, UserRepository userRepository) {
        this.storageService = storageService;
        this.userRepository = userRepository;
    }

    @PostMapping("/api/profile/pfp")
    void saveProfilePicture(@RequestParam MultipartFile profilePicture) throws Exception {
        this.storageService.store(profilePicture);
    }

    @GetMapping("/api/profile/pfp")
    String getProfilePicturreUrl() {
        return ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString()
                + "/images";
    }

    @GetMapping("/images/{fileName}")
    Resource getImageAsResource(@PathVariable String fileName) {
        final Path path = this.storageService.getStorageLocation().resolve(fileName);
        return new PathResource(path);
    }
}
