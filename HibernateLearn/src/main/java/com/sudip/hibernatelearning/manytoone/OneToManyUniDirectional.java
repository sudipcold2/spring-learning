package com.sudip.hibernatelearning.manytoone;

import com.sudip.hibernatelearning.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class OneToManyUniDirectional {

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

            int courseId = 1103;
            //Course course = session.get(Course.class, courseId);
            //System.out.println("Reviews ----------" + course.getReviews());

            Course nwC = new Course("Sudip's java course");

            Review review1 = new Review("Awesome course");
            Review review2 = new Review("Aladai Instructor");

            nwC.addReview(review1);
            nwC.addReview(review2);

            session.save(nwC);

            session.getTransaction().commit();

        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
