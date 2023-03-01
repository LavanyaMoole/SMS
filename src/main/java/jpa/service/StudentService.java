package jpa.service;

import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;



//implementation of StudentDAO
public class StudentService implements StudentDAO
{
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;
//retrieving list of students
    @Override
    public List<Student> getAllStudents()
    {
        factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();
       Query q= session.createQuery("from Student",Student.class);
      List<Student> students= q.getResultList();
      transaction.commit();
      session.close();
      return students;
    }
//getting student by email
    @Override
    public Student getStudentByEmail(String sEmail)
    {
        factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();
       Student s= session.get(Student.class,sEmail);
        transaction.commit();
        session.close();
       return s;


    }
//validating student credentials
    @Override
    public boolean validateStudent(String sEmail,String sPass)
    {
        factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();
        Student s=session.load(Student.class,sEmail);
        try{
        if(s.getsEmail().equals(sEmail)&&s.getsPass().equals(sPass))
        {
            session.close();
            return true;
        }}catch(Exception e){
            e.printStackTrace();
        }
        session.close();
        return false;
    }
//registering student for the particular courseid
    @Override
    public void registerStudentToCourse(String sEmail,int cId)
    {
        factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();

      //List<Course> lc= cs.getAllCourses();
      Course newCourse=session.get(Course.class,cId);
      StudentService ss=new StudentService();
     Student s= ss.getStudentByEmail(sEmail);
        List<Course> studentcourselist=s.getsCourses();
        studentcourselist.add(newCourse);
        s.setsCourses(studentcourselist);
        session.saveOrUpdate(s);
        transaction.commit();
        session.close();


    }
// retrieving list of student courses
    @Override
    public List<Course> getStudentCourses(String sEmail) {
        factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();
        Student s=session.load(Student.class,sEmail);
       List<Course> courselist= s.getsCourses();
        transaction.commit();
        session.close();
       return courselist;
    }
}
