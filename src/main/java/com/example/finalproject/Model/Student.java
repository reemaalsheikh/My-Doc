package com.example.finalproject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    private Integer id;// Same as User ID

    //@AssertFalse
    @Column(columnDefinition = "boolean default false")
    private boolean isEnrolled;

    @Column(columnDefinition = "datetime default (current_timestamp)")
    private LocalDate enrollmentDate;


  //Relations

    @OneToOne
    @MapsId
    @JsonIgnore
    private User user;




    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;

//    @OneToMany(mappedBy = "student")
//    private List<Review> reviews;

//    @ManyToMany
//    @JoinTable(
//            name = "student_club",
//            joinColumns = @JoinColumn(name = "student_id"),
//            inverseJoinColumns = @JoinColumn(name = "club_id")
//    )
//    private List<Club> clubs;



}
