package com.xworkz.xworkzapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course_enrollment")
public class EnrollmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int studentId;
    public String name;
    public String email;
    @Column(name = "course_name")
    public String courseName;
    @Column(name = "start_date")
    public String startDate;
    public String comments;
}
