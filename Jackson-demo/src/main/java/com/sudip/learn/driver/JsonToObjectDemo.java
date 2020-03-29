package com.sudip.learn.driver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sudip.learn.entity.Student;

import java.io.File;
import java.net.URL;

public class JsonToObjectDemo {

    public static void main(String[] args) {

        try{

            ObjectMapper mapper = new ObjectMapper();

            //URL resource = DriverProgram.class.getResource("/data/sample-lite.json");
            URL resource = JsonToObjectDemo.class.getResource("/data/little-complex.json");

            Student student = mapper.readValue(new File(resource.getPath()), Student.class);

            System.out.println("Student's First Name :: " + student.getFirstName());
            System.out.println("Student's Last Name :: " + student.getLastName());

            System.out.println("The Student is from :: " + student.getAddress().getCountry());

            System.out.println("Known Programming langs :: " + student.getProgLangs());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
