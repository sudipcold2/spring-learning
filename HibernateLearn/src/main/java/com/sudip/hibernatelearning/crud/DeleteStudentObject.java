package com.sudip.hibernatelearning.crud;

import com.sudip.hibernatelearning.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentObject {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try{
            int id = 11;
            Session session = factory.getCurrentSession();

            session.beginTransaction();

            Student persistStudent = session.get(Student.class, id);

            session.delete(persistStudent);

            session.createQuery("delete from Student s where s.id='12'").executeUpdate();

            session.getTransaction().commit();

        }finally{
            factory.close();
        }
    }
}
