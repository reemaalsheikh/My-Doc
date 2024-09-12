package com.example.finalproject.Controller;

import com.example.finalproject.Api.ApiResponse;
import com.example.finalproject.DTO.ProfileDTO;
import com.example.finalproject.Service.ProfileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;

    @GetMapping("/get")
    public ResponseEntity getAllProfiles(){
        return ResponseEntity.status(200).body(profileService.getAllProfiles());
    }

    @PostMapping("/add/{id}")
    public ResponseEntity addProfile(@Valid @RequestBody ProfileDTO profileDTO,@PathVariable Integer id){
        profileService.addProfile(profileDTO,id);
        return ResponseEntity.status(200).body(new ApiResponse("Profile added Successfully!"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateProfile(@Valid @RequestBody ProfileDTO profileDTO,@PathVariable Integer id){
        profileService.updateProfile(profileDTO,id);
        return ResponseEntity.status(200).body(new ApiResponse("Profile updated successfully!"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteProfile(@PathVariable Integer id){
        profileService.deleteProfile(id);
        return ResponseEntity.status(200).body(new ApiResponse("Profile deleted successfully!"));
    }
}
