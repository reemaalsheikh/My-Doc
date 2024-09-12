package com.example.finalproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "First name should not be empty!")
    @Column(columnDefinition = "varchar(20) not null")
    private String firstName;

    @NotEmpty(message = "Last name should not be empty!")
    @Column(columnDefinition = "varchar(20) not null")
    private String lastName;

    @NotEmpty(message = "username should not be EMPTY!")
    @Size(min=4 , max=10 , message = "user name size should be between 4 - 10")
    @Column(columnDefinition = "varchar(50) not null unique")
    private String username;

    @NotEmpty(message ="Phone number cannot be null")
    @Pattern(regexp = "^(05|0)[0-9]{8}$" ,message = " Phone number Must start with 05, consists of exactly 10 digits")
    @Column(columnDefinition = "varchar(10) not null unique")
    private String phoneNumber;

    @NotNull(message = "Age should not be Null!")
    @Column(columnDefinition = "int not null")
    private int age;

    @NotEmpty(message = "Role should not be EMPTY!")
    @Pattern(regexp = "^(STUDENT|TUTOR|ADMIN)$", message = "Role has 3 valid inputs only(STUDENT,TUTOR,ADMIN).")
//@Column(columnDefinition = "varchar(15) check (role='ADMIN' or role='TUTOR' or role='STUDENT')")
    private String role;

    @Email
    @NotEmpty(message = "Email should not be Empty!")
    @Column(columnDefinition = "varchar(50) not null unique")
    private String email;

    @NotEmpty(message = "Education level should not be EMPTY!")
    @Column(columnDefinition = "varchar(20) not null")
    private String education_level; //UnderGraduate



    @OneToOne
    @MapsId
    @JsonIgnore
    private User user;


}
