package com.sudip.hibernatelearning.manytomany;

import com.sudip.hibernatelearning.entity.Course;
import com.sudip.hibernatelearning.entity.Instructor;
import com.sudip.hibernatelearning.entity.InstructorDetail;
import com.sudip.hibernatelearning.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCourse {

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
            int courseId = 1101;
            Course course = session.get(Course.class, courseId);
            session.delete(course);

            session.getTransaction().commit();
        }finally {
            session.close();
            factory.close();
        }
    }
}
