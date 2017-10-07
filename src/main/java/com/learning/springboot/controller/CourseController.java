package com.learning.springboot.controller;


import com.learning.springboot.model.Course;
import com.learning.springboot.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ComponentScan({ "com.learning.springboot.model", "com.learning.springboot.service" })
public class CourseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseService courseServiceImpl;

    @PostMapping("/courses")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Course createCourse(@RequestBody Course course) {
        logger.info("Executing create course");
        return courseServiceImpl.addCourse(course);
    }

    @GetMapping("/courses")
    @ResponseStatus(value = HttpStatus.OK)
    public List<Course> getCourses() {
        logger.info("Executing get all course");
        return courseServiceImpl.getAllCourses();
    }

    @PutMapping("/courses/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Course updateCourse(@RequestBody Course course, @PathVariable Integer id) {
        return courseServiceImpl.updateCourse(course, id);
    }

    @GetMapping("/courses/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public Course getCourseById(@PathVariable Integer id) {
        return courseServiceImpl.getCourseById(id);
    }

    @DeleteMapping("/courses/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteCourse(@PathVariable Integer id) {
        courseServiceImpl.deleteCourse( id);
    }


}
