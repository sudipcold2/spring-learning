package com.sudip.hibernatelearning.manytoone;

import com.sudip.hibernatelearning.entity.Course;
import com.sudip.hibernatelearning.entity.Instructor;
import com.sudip.hibernatelearning.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ManyToOneDemo {


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

            Course course1 = new Course("Java : learn ultimate way 2");
            Course course2 = new Course("C++ : A new way");

            instructor.addCourse(course1);
            instructor.addCourse(course2);

            session.save(course1);
            session.save(course2);

            session.getTransaction().commit();

        }finally {
            session.close();
            sessionFactory.close();
        }
    }
}
