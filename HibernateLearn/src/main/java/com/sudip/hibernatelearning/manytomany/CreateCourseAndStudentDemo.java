package com.sudip.hibernatelearning.manytomany;

import com.sudip.hibernatelearning.entity.Course;
import com.sudip.hibernatelearning.entity.Instructor;
import com.sudip.hibernatelearning.entity.InstructorDetail;
import com.sudip.hibernatelearning.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndStudentDemo {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();

            Course tempCourse = new Course("Go lang:Learn the hard way");
            session.save(tempCourse);

            Student student1 = new Student("Sushmita", "sen", "sus@gmail.com");
            Student student2 = new Student("Sharuq", "uddin", "sha@gmail.com");

            tempCourse.addStudent(student1);
            tempCourse.addStudent(student2);

            session.save(student1);
            session.save(student2);

            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
