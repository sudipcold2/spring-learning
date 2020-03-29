package com.sudip.hibernatelearning.onetoone;

import com.sudip.hibernatelearning.entity.Instructor;
import com.sudip.hibernatelearning.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BiDirectionalDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();

            int theId = 101;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);
            if(instructorDetail != null){
                System.out.println();
                System.out.println(instructorDetail);

                System.out.println();
                System.out.println(instructorDetail.getInstructor());
                System.out.println();
            }

            session.getTransaction().commit();

        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
