package com.learning.springboot.service;


import com.learning.springboot.Exceptions.EntityNotFoundException;
import com.learning.springboot.mapper.CourseMapper;
import com.learning.springboot.model.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Course> getAllCourses() {
        return courseMapper.findAll();
    }

    @Override
    public Course updateCourse(Course course, Integer id) {

        Course existingCourse = courseMapper.getCourseById(id);

        existingCourse.setCredits(course.getCredits());
        existingCourse.setName(course.getName());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setProfessor(course.getProfessor());

        courseMapper.update(existingCourse);

        return courseMapper.getCourseById(id);
    }

    @Override
    public Course addCourse(Course course) {
        courseMapper.insert(course);
        return course;
    }

    @Override
    public void deleteCourse(Integer id) {
        courseMapper.delete(id);
    }

    @Override
    public Course getCourseById(Integer id) {

        Course course = courseMapper.getCourseById(id);
         if (course != null) {
             return course;
         } else {
            throw new EntityNotFoundException("Entity not Found");
         }
    }
}
