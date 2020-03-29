package com.sudip.hibernatelearning.manytomany;

import com.sudip.hibernatelearning.entity.Course;
import com.sudip.hibernatelearning.entity.Instructor;
import com.sudip.hibernatelearning.entity.InstructorDetail;
import com.sudip.hibernatelearning.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddMoreCoursesForStudent {

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
            int studentId = 13;
            Student student = session.get(Student.class, studentId);
            System.out.println();
            System.out.println(student.getCourses());
            System.out.println();

            Course course1 = new Course("James Gosling Java");
            Course course2 = new Course("Stroustroup C++");

            student.addCourse(course1);
            student.addCourse(course2);

            session.save(course1);
            session.save(course2);

            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
