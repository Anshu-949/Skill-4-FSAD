package com.example.main;
import com.example.dao.StudentDAO;
import com.example.entity.Student;
import java.util.List;
import java.util.Scanner;
public class MainApp 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();
        int choice;
        do 
        {
            System.out.println("\n CRUD USING HIBERNATE MENU ");
            System.out.println("1. Insert Student");
            System.out.println("2. Get Student Details  by ID");
            System.out.println("3. Get All Students Details ");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer
            switch (choice) 
            {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter City: ");
                    String city = sc.nextLine();
                    Student s = new Student(name, city);
                    dao.saveStudent(s);
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    Student st = dao.getStudent(id);
                    if (st != null) 
                    {
                        System.out.println("ID: " + st.getId());
                        System.out.println("Name: " + st.getName());
                        System.out.println("City: " + st.getCity());
                    } 
                    else 
                    {
                        System.out.println("Student not found.");
                    }
                    break;
                case 3:
                    List<Student> list = dao.getAllStudents();
                    if (list.isEmpty()) 
                    {
                        System.out.println("No students found.");
                    } 
                    else 
                    {
                        for (Student stud : list) 
                        {
                            System.out.println(stud.getId() + " | " +stud.getName() + " | " +stud.getCity());
                        }
                    }
                    break;

                case 4:
                    System.out.print("Enter Student ID to Update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    Student up = dao.getStudent(uid);
                    if (up != null) 
                    {
                        System.out.print("Enter New Name: ");
                        up.setName(sc.nextLine());
                        System.out.print("Enter New City: ");
                        up.setCity(sc.nextLine());
                        dao.updateStudent(up);
                    } 
                    else 
                    {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Student ID to Delete: ");
                    int did = sc.nextInt();
                    dao.deleteStudent(did);
                    break;

                case 6:
                    System.out.println("Exiting Application");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}
