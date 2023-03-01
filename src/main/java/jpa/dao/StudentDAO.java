package jpa.dao;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

import java.util.List;


//student data adccess object
public interface StudentDAO
{
   List<Student> getAllStudents();

    Student getStudentByEmail(String email);

   boolean  validateStudent(String email,String password);

   void registerStudentToCourse(String email,int cId);

    List<Course> getStudentCourses(String email);
}
