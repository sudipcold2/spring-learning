package com.sudip.hibernatelearning.onetoone;

import com.sudip.hibernatelearning.entity.Instructor;
import com.sudip.hibernatelearning.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Instructor instructor = new Instructor("Rimi", "Bera", "rimibera650@gmail.com");

        InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com/rimicold",
                "Dancing");

        instructor.setInstructorDetail(instructorDetail);

        Session session = sessionFactory.getCurrentSession();
        try{

            session.beginTransaction();

            session.save(instructor);

            session.getTransaction().commit();


        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
