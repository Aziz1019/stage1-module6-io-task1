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

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        Profile dataFromFile = fileReader.getDataFromFile(new File("D:\\epam-prep\\epam-lab\\mjc\\stages\\stage1-module6-io-task1\\src\\main\\resources\\Profile.txt"));
        System.out.println(dataFromFile.getName() + " " + dataFromFile.getAge() + " " + dataFromFile.getEmail() + " " + dataFromFile.getPhone());

    }
}

/*
       // File path is passed as parameter
        File file = new File(
            "C:\\Users\\pankaj\\Desktop\\test.txt");

        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)

        // Creating an object of BufferedReader class
        BufferedReader br
            = new BufferedReader(new FileReader(file));

        // Declaring a string variable
        String st;
        // Condition holds true till
        // there is character in a string
        while ((st = br.readLine()) != null)

            // Print the string
            System.out.println(st);
    }
}
* */
