package com.example.finalproject.Service;

import com.example.finalproject.Api.ApiException;
import com.example.finalproject.DTO.ProfileDTO;
import com.example.finalproject.Model.Profile;
import com.example.finalproject.Model.Tutor;
import com.example.finalproject.Model.User;
import com.example.finalproject.Repository.AuthRepository;
import com.example.finalproject.Repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final AuthRepository authRepository;

    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    public void addProfile (ProfileDTO profileDTO , Integer id) {
        User user = authRepository.findUserById(id);
        if (user==null){
            throw new ApiException("User not found");}

        if (user.getProfile() == null) {
            Profile profile = new Profile();
            user.setProfile(profile);
        }
        Profile profile = user.getProfile();

        profile.setFirstName(profileDTO.getFirstName());
        profile.setLastName(profileDTO.getLastName());
        profile.setUsername(profileDTO.getUsername());
        profile.setEmail(profileDTO.getEmail());
        profile.setPhoneNumber(profileDTO.getPhoneNumber());
        profile.setAge(profileDTO.getAge());
        profile.setRole(profileDTO.getRole());
        profile.setEducation_level(profileDTO.getEducation_level());

        profile.setUser(user);

        profileRepository.save(profile);
        authRepository.save(user);
    }

    public void updateProfile (ProfileDTO profileDTO, Integer id) {
        Profile profile = profileRepository.findProfileById(id);
        if (profile == null){
            throw new ApiException("Profile not found");
        }
        profile.setFirstName(profileDTO.getFirstName());
        profile.setLastName(profileDTO.getLastName());
        profile.setUsername(profileDTO.getUsername());
        profile.setEmail(profileDTO.getEmail());
        profile.setPhoneNumber(profileDTO.getPhoneNumber());
        profile.setAge(profileDTO.getAge());
        profile.setRole(profileDTO.getRole());
        profile.setEducation_level(profileDTO.getEducation_level());

        profileRepository.save(profile);
    }

    public void deleteProfile (Integer id) {
        Profile profile = profileRepository.findProfileById(id);
        if (profile == null){
            throw new ApiException("Profile not found");
        }
        profileRepository.delete(profile);
    }




}
