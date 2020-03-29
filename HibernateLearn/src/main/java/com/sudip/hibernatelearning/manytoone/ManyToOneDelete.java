package com.sudip.hibernatelearning.manytoone;

import com.sudip.hibernatelearning.entity.Course;
import com.sudip.hibernatelearning.entity.Instructor;
import com.sudip.hibernatelearning.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToOneDelete {


    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            int theId = 101;

            Course course = session.get(Course.class, theId);

            System.out.println("To be Deleted :" + course);

            session.delete(course);

            session.getTransaction().commit();

        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
