package jpa.service;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import org.junit.After;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest
{
    public static StudentService ss;
    public static CourseService cs;
    public static  Student s;
    @Before
    public static void init()
    {
        System.out.println("Test case started");
    }
    //comparing list of all courses with student courses
    @Test
    public void actualStudentCoursesTest()
    {
        StudentService ss=new StudentService();
        CourseService cs=new CourseService();
        Student s=new Student();

        String sEmail="sbowden1@yellowbook.com";
        //Expected
        List<Course> listOfCourse= cs.getAllCourses();
       //Actual
        List<Course> studentCourses=ss.getStudentCourses(sEmail);
        System.out.println("List of all available courses");
        for(Course c:listOfCourse )
        {
            System.out.println(c.getcName());
        }
        System.out.println();
        System.out.println("Student registered courses");
        for(Course c: studentCourses)
        {
            System.out.println(c.getcName());
        }
        assertNotEquals(listOfCourse,studentCourses);
        //assertTrue(listOfCourse.contains(studentCourses));
    }

    @After
    public void  afterMethod(){
        System.out.println("test case successfully passed");

    }

}