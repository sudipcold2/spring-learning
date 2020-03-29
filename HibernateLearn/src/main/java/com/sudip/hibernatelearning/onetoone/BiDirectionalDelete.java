package com.sudip.hibernatelearning.onetoone;

import com.sudip.hibernatelearning.entity.Instructor;
import com.sudip.hibernatelearning.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BiDirectionalDelete {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

            int theId = 104;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);
            if (instructorDetail != null) {
                System.out.println(instructorDetail);

                instructorDetail.getInstructor().setInstructorDetail(null);

                session.delete(instructorDetail);
            }

            session.getTransaction().commit();


        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
