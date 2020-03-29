package com.sudip.hibernatelearning.manytoone;

import com.sudip.hibernatelearning.entity.Course;
import com.sudip.hibernatelearning.entity.Instructor;
import com.sudip.hibernatelearning.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class FetchJoinDemo {

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

            Query<Instructor> query = session.createQuery("select i from Instructor i "
                    + "JOIN FETCH i.courses "
                    + "where i.id=:theInstructionId", Instructor.class);

            query.setParameter("theInstructionId", theId);

            Instructor instructor = query.getSingleResult();

            System.out.println(instructor);

            System.out.println(instructor.getCourses());

            session.getTransaction().commit();

        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
