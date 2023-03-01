package jpa.dao;

import jpa.entitymodels.Course;

import java.util.List;

//course data access object
public interface CourseDAO {
   List<Course> getAllCourses();
   Course getCourseById(int cId);
}
