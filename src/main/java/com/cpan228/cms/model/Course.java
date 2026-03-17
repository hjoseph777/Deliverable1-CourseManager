package com.cpan228.cms.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Course code is required")
    @Size(min = 4, max = 8, message = "Code must be between 4 and 8 characters")
    @Column(unique = true)
    private String code;

    @NotBlank(message = "Course name is required")
    private String name;

    @Min(value = 1, message = "Credits cannot be less than 1")
    @Max(value = 5, message = "Credits cannot exceed 5")
    private Integer credits;

    @NotBlank(message = "Department must be selected")
    private String department;

    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public Course() {}

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getCredits() {
        return credits;
    }
    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
