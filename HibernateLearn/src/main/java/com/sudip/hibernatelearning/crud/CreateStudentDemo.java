package com.sudip.hibernatelearning.crud;

import com.sudip.hibernatelearning.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args) {


        //create session factory
        SessionFactory factory = new Configuration()
                                    .configure("hibernate.cfg.xml")
                                    .addAnnotatedClass(Student.class)
                                    .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();

        try{

            //use session object

            //create student object
            Student temp = new Student("Sudip", "Ghosh", "sudipcold@gmail.com");
            Student temp2 = new Student("Kunal", "Saha", "kunalsaha@gmail.com");
            Student temp3 = new Student("Kamal", "Gachi", "kamalgachi@gmail.com");
            //start transaction
            session.beginTransaction();

            //save student object
            session.save(temp);
            session.save(temp2);
            session.save(temp3);

            //commit transaction
            session.getTransaction().commit();

        }finally {
            factory.close();
        }
    }
}
