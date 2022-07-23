package com.core;

import com.domain.Staff;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class GsonExample2 {
    public static void main(String[] args) {

        Gson gson = new Gson();

        try (Reader reader = new FileReader("json/student.json")) {

            // Convert JSON File to Java Object
            Staff[] staff = gson.fromJson(reader, Staff[].class);

            // print staff
            for (Staff staff1 : staff) {
                System.out.println(staff1);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
