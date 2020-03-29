package com.sudip.hibernatelearning.manytoone;

import com.sudip.hibernatelearning.entity.Course;
import com.sudip.hibernatelearning.entity.Instructor;
import com.sudip.hibernatelearning.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToOneRetrieve {

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
            int theId = 1;
            Instructor instructor = session.get(Instructor.class, theId);

            System.out.println(instructor.getCourses());

            session.getTransaction().commit();

        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
