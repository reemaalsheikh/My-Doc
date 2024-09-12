package com.example.finalproject.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProfileDTO {


    @NotEmpty(message = "First name should not be empty!")
    private String firstName;

    @NotEmpty(message = "Last name should not be empty!")
    private String lastName;

    @NotEmpty(message = "username should not be EMPTY!")
    private String username;

    @NotEmpty(message ="Phone number cannot be null")
    private String phoneNumber;

    @NotNull(message = "Age should not be Null!")
    private int age;

    @NotEmpty(message = "Role should not be EMPTY!")
    @Pattern(regexp = "^(STUDENT|TUTOR|ADMIN)$", message = "Role has 3 valid inputs only(STUDENT,TUTOR,ADMIN).")
    private String role;

    @Email
    @NotEmpty(message = "Email should not be Empty!")
    private String email;

    @NotEmpty(message = "Education level should not be EMPTY!")
    private String education_level; //UnderGraduate

}
