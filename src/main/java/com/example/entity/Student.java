package com.example.entity;
import javax.persistence.*;
@Entity
@Table(name = "students")
public class Student 
{
    @Id
    /*@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_seq_gen")
    @SequenceGenerator(name = "student_seq_gen",sequenceName = "student_seq",allocationSize = 1)*/
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String city;
    public Student() 
    {
    	
    }
    public Student(String name, String city) 
    {
        this.name = name;
        this.city = city;
    }

    public int getId() 
    { 
    	return id;
    }
    public String getName() 
    { 
    	return name; 
    }
    public String getCity() 
    { 
    	return city; 
    }

    public void setName(String name) 
    { 
    	this.name = name; 
    }
    public void setCity(String city)
    { 
    	this.city = city; 
    }
}
