package com.example.dao;
import com.example.entity.Student;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;
public class StudentDAO 
{
    public void saveStudent(Student s) 
    {
        Transaction tx = null;
        try (Session session = HibernateUtil.getFactory().openSession()) 
        {
            tx = session.beginTransaction();
            session.save(s);
            tx.commit();
            System.out.println("Student saved successfully.");
        }
    }

  
    public Student getStudent(int id) 
    {
        try (Session session = HibernateUtil.getFactory().openSession()) 
        {
            return session.get(Student.class, id);
        }
    }

    
    public List<Student> getAllStudents() 
    {
        try (Session session = HibernateUtil.getFactory().openSession()) 
        {
            return session.createQuery("from Student", Student.class).list();
        }
    }

    
    public void updateStudent(Student s) 
    {
        Transaction tx = null;
        try (Session session = HibernateUtil.getFactory().openSession()) 
        {
            tx = session.beginTransaction();
            session.update(s);
            tx.commit();
            System.out.println("Student updated successfully.");
        }
    }


    public void deleteStudent(int id) 
    {
        Transaction tx = null;
        try (Session session = HibernateUtil.getFactory().openSession()) 
        {
            Student s = session.get(Student.class, id);
            if (s == null) 
            {
                System.out.println("Student not found.");
                return;
            }

            tx = session.beginTransaction();
            session.delete(s);
            tx.commit();
            System.out.println("Student deleted successfully.");
        }
    }
}
