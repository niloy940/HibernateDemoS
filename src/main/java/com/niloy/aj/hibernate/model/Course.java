package com.niloy.aj.hibernate.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    private String courseCode;
    private String courseTitle;
    private double creditHours;
    @ManyToMany
    private List<Student> studentList;

    public Course() {
        studentList = new ArrayList<>();
    }

    public Course(String courseCode, String courseTitle, double creditHours) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.creditHours = creditHours;
        studentList = new ArrayList<>();
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public double getCreditHours() {
        return creditHours;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void addStudent(Student student){
        studentList.add(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", courseTitle='" + courseTitle + '\'' +
                ", creditHours=" + creditHours +
                ", studentList=" + studentList +
                '}';
    }
}
