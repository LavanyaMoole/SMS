package org.example;

import jpa.entitymodels.Course;
import jpa.service.CourseService;
import jpa.service.StudentService;

import java.util.List;
import java.util.Scanner;

public class RunnerSms
{
    static StudentService ss = new StudentService();
    static CourseService cs = new CourseService();
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int userInput;
        System.out.println("Are you a(n) :\n1.student\n2.Quit\n" +
                "please enter 1 or 2");
        System.out.println();
        // save user selection
        userInput = input.nextInt();
        switch (userInput)
        {
            case 1:

                //validating student for given email and password
                System.out.println("Enter your email:");
                String sEmail = input.next();
                System.out.println("Enter your password:");
                String sPass = input.next();
                if(ss.validateStudent(sEmail,sPass))
                {
                    List<Course> courses=ss.getStudentCourses(sEmail);

                    //list of student courses before register

                    System.out.println("My classes before registering");
                    System.out.println();
                    System.out.printf("%5s%15S%15s\n", "ID", "Course", "Instructor");
                    for(Course c:courses)
                    {
                        System.out.printf("%-5s|%-15s|%-15s \n", c.getcId()
                                , c.getcName(),c.getcInstructorName());

                    }
                    System.out.println();
                    //registering for courses
                    System.out.println("1. Register for a new Class");
                    System.out.println("2. Log Out");
                    System.out.print("Answer: \n");
                    userInput = input.nextInt();
                    switch(userInput)
                    {
                        case 1:
                        List<Course> allcourses=cs.getAllCourses();
                       List<Course> studentcourse= ss.getStudentCourses(sEmail);
                       System.out.println("All Courses");
                            System.out.println();
                       System.out.printf("%5s%15S%15s\n", "ID", "Course", "Instructor");
                       for(Course c:allcourses)
                       {
                           System.out.printf("%-5s|%-15s|%-15s \n", c.getcId(),
                                    c.getcName(),c.getcInstructorName());

                       }
                            System.out.println();
                        System.out.println("Enter Course Number: ");
                        int num = input.nextInt();
                        ss.registerStudentToCourse(sEmail,num);
                        //list of courses after registering new course
                        List<Course> listOfCoursesAfterRegister= ss.getStudentCourses(sEmail);
                        System.out.println("My classes after registering:");
                            System.out.println();
                        System.out.printf("%5s%15S%15s\n", "ID", "Course", "Instructor");
                       for( Course c:listOfCoursesAfterRegister)
                       {
                           System.out.printf("%-5s|%-15s|%-15s \n", c.getcId(),
                                    c.getcName(),c.getcInstructorName());

                       }
                            System.out.println();
                            System.out.println();

                        System.out.println("course added successfully");
                        case 2:
                            System.out.println("You have been signed out.");
                            input.close();
                            System.exit(1);
                            break;


                    }

                }
                else
                {
                    // case of wrong information in login credentials
                    System.out.println("Sorry! Wrong credentials!");
                    System.out.println("Try again");
                    System.out.println("You have been signed out.");
                    input.close();
                    System.exit(1);}
            case 2:
                System.out.println("You have been signed out.");
                input.close();
                System.exit(1);
                break;

        }


    }
}
