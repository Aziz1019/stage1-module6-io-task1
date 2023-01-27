package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(file))) {
            String st;
            String data = "";
            while ((st = br.readLine()) != null) {
                data += st + " ";
            }

            String[] dataArr = data.split(" ");
            profile.setName(dataArr[1]);
            profile.setAge(Integer.parseInt(dataArr[3]));
            profile.setEmail(dataArr[5]);
            profile.setPhone(Long.parseLong(dataArr[7]));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return profile;
    }
}