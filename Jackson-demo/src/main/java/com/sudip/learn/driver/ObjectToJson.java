package com.sudip.learn.driver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sudip.learn.entity.Student;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ObjectToJson {

    public static void main(String[] args) {

        Student myStudent = new Student();
        myStudent.setFirstName("Rimi");
        myStudent.setLastName("Bera");
        myStudent.setActive(true);
        myStudent.setId(2);

        ObjectMapper mapper = new ObjectMapper();

        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        URL resource = ObjectToJson.class.getResource("/data");

        try {
            mapper.writeValue(new File(resource.getPath() + "/output.json"), myStudent);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
