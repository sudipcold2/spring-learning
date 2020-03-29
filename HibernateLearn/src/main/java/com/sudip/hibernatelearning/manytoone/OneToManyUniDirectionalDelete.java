package com.sudip.hibernatelearning.manytoone;

import com.sudip.hibernatelearning.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToManyUniDirectionalDelete {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try{

            session.beginTransaction();


            int courseId = 1106;
            Course course = session.get(Course.class, courseId);
            System.out.println(course.getReviews());
            session.delete(course);

            session.getTransaction().commit();

        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
