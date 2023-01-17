package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class FileReader {

    public Profile getDataFromFile(File file) {
        String [] results = new String[4];
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file.getAbsoluteFile()))) {
            String line;
            int counter = 0;
            while ((line = reader.readLine()) != null){
                String [] items = line.split(" ");
                results[counter] = items[1];
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String name = results[0];
        int age = Integer.parseInt(results[1]);
        String email = results[2];
        int number = Integer.parseInt(results[3]);

        return new Profile(name,age,email,(long)number);
    }
}
