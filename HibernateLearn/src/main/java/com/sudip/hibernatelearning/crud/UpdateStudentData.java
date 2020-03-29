package com.sudip.hibernatelearning.crud;

import com.sudip.hibernatelearning.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentData {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try{

            Session session = factory.getCurrentSession();
            session.beginTransaction();
            int id = 12;
            Student presistantStudent = session.get(Student.class, id);
            presistantStudent.setEmail("sumitbera@gmail.com");

            session.createQuery("update Student s set s.lastName='Bera' where s.firstName='Rimi'").executeUpdate();

            session.getTransaction().commit();


        }finally {
            factory.close();
        }
    }
}
