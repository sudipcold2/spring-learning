package com.sudip.hibernatelearning.crud;

import com.sudip.hibernatelearning.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueringObjects {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        try{

            Session session = factory.getCurrentSession();

            session.beginTransaction();

            //printing all students
            List<Student> allStudentinDB = session.createQuery("from Student").getResultList();
            for(Student s : allStudentinDB){
                System.out.println(s);
            }

            //printing all students with last name "ghosh"
            System.out.println();
            List<Student> studentsWithLastNameGhosh = session.createQuery("from Student s where s.lastName='Ghosh'")
                    .getResultList();
            for(Student s : studentsWithLastNameGhosh){
                System.out.println(s);
            }

            //printing all students with last name "ghosh" or "bera"
            System.out.println();
            List<Student> studentsWithLastName = session.createQuery("from Student s where " +
                    "s.lastName='Ghosh' or s.lastName='bera'").getResultList();
            for(Student s : studentsWithLastName){
                System.out.println(s);
            }


            //Like Clause
            System.out.println();
            List<Student> studentsWithEmailIdGmail = session.createQuery("from Student s where " +
                    "s.email LIKE '%yahoo.com'").getResultList();

            for(Student s : studentsWithEmailIdGmail){
                System.out.println(s);
            }

            session.getTransaction().commit();

        }finally {
            factory.close();
        }
    }
}
