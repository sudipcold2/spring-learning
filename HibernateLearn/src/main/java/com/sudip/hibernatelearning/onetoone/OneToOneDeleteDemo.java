package com.sudip.hibernatelearning.onetoone;

import com.sudip.hibernatelearning.entity.Instructor;
import com.sudip.hibernatelearning.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class OneToOneDeleteDemo {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();

            int theId = 2;
            Instructor instructorToDelete = session.get(Instructor.class, theId);
            if(instructorToDelete != null){
                System.out.println(instructorToDelete);

                session.delete(instructorToDelete);
            }

            session.getTransaction().commit();



        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
