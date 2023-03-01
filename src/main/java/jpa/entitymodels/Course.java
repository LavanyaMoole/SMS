package jpa.entitymodels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Course")
public class Course
{
    public Course()
    {

    }

    public Course(int cId, String cName, String cInstructorName)
    {
        this.cId = cId;
        this.cName = cName;
        this.cInstructorName = cInstructorName;
    }

    @Id
    @Column(nullable = false)
    private int cId;
    @Column(nullable = false)
    private String cName;
    @Column(nullable = false)
    private String cInstructorName;

    public int getcId()
    {
        return cId;
    }

    public void setcId(int cId)
    {
        this.cId = cId;
    }

    public String getcName()
    {
        return cName;
    }

    public void setcName(String cName)
    {
        this.cName = cName;
    }

    public String getcInstructorName()
    {
        return cInstructorName;
    }

    public void setcInstructorName(String cInstructorName)
    {
        this.cInstructorName = cInstructorName;
    }



}
