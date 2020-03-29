package com.sudip.hibernatelearning.crud;

import com.sudip.hibernatelearning.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentData {

    public static void main(String[] args) {
        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try{

            //create student object
            Student temp = new Student("Sumit", "Bera", "rimibera@yahoo.com");
            //start transaction
            session.beginTransaction();

            //save student object
            session.save(temp);

            //commit transaction
            session.getTransaction().commit();

            System.out.println("Student id ::" +  temp.getId());

            session = factory.getCurrentSession();

            session.beginTransaction();

            Student retrievedStudent = session.get(Student.class, temp.getId());

            System.out.println(retrievedStudent);

            session.getTransaction().commit();

        }finally {
            factory.close();
        }
    }
}
