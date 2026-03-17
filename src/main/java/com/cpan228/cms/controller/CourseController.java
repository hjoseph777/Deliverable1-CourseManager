package com.cpan228.cms.controller;

import com.cpan228.cms.model.Course;
import com.cpan228.cms.repository.CourseRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
public class CourseController {

    private final CourseRepository repository;

    public CourseController(CourseRepository repository) {
        this.repository = repository;
    }

    // List view with Optional Filters and Pagination
    @GetMapping
    public String listCourses(
            @RequestParam(required = false) String department,
            @RequestParam(required = false, defaultValue = "0") Integer minCredits,
            @PageableDefault(size = 5, sort = "code", direction = Sort.Direction.ASC) Pageable pageable, 
            Model model) {
        
        if (department != null && department.trim().isEmpty()) {
            department = null;
        }

        Page<Course> coursePage = repository.findByDepartmentAndCreditsGreaterThanEqual(
                                    department, minCredits, pageable);
        model.addAttribute("page", coursePage);
        model.addAttribute("department", department);
        model.addAttribute("minCredits", minCredits);
        return "course/list";
    }

    // Show Create Form
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("course", new Course());
        return "course/form";
    }

    // Process Create Form with Validation
    @PostMapping("/create")
    public String processCreate(
            @Valid @ModelAttribute("course") Course course,
            BindingResult bindingResult) {
        
        if (bindingResult.hasErrors()) {
            return "course/form"; // Return to form with errors displayed
        }
        repository.save(course);
        return "redirect:/courses?success=true";
    }
}
