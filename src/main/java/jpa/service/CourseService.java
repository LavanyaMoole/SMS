package jpa.service;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

//implementation of CourseDAO
public class CourseService implements CourseDAO
{
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    //retrieving list of all courses
    @Override
    public List<Course> getAllCourses()
    {
        factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();
        Query q= session.createQuery("from Course",Course.class);
       List<Course> c=(List<Course>)q.getResultList();
       transaction.commit();
       session.close();
       return c;

    }
//getting course by courseid
    @Override
    public Course getCourseById(int cId)
    {
        factory = new Configuration().configure().buildSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();
        Course c=session.load(Course.class,cId);
        transaction.commit();
        session.close();
        return c;
    }
}
