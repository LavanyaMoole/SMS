package jpa.entitymodels;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Student")
public class Student {
    public Student()
    {

    }

    public Student(String sEmail, String sName, String sPass, List<Course> sCourses) {
        this.sEmail = sEmail;
        this.sName = sName;
        this.sPass = sPass;
        this.sCourses = sCourses;
    }

    public Student(String sEmail, String sName, String sPass)
    {
        this.sEmail = sEmail;
        this.sName = sName;
        this.sPass = sPass;
    }

    @Id
    @Column(nullable = false)
    private String sEmail;
    @Column(nullable = false)
    private String sName;
    @Column(nullable = false)
    private String sPass;
    @ManyToMany(targetEntity = Course.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    List<Course> sCourses;

    public List<Course> getsCourses() {
        return sCourses;
    }

    public String getsEmail()
    {
        return sEmail;
    }

    public void setsEmail(String sEmail)
    {
        this.sEmail = sEmail;
    }

    public String getsName()
    {
        return sName;
    }

    public void setsName(String sName)
    {
        this.sName = sName;
    }

    public String getsPass()
    {
        return sPass;
    }

    public void setsPass(String sPass)
    {
        this.sPass = sPass;
    }



    public void setsCourses(List<Course> sCourses)
    {
        this.sCourses = sCourses;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getsEmail().equals(student.getsEmail()) && getsName().equals(student.getsName()) && getsPass().equals(student.getsPass());
    }





}
