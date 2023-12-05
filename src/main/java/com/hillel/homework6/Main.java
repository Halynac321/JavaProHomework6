package com.hillel.homework6;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static String filePath="/Users/gc/IdeaProjects/JavaProHomework6/src/main/java/com/hillel/homework6/log.txt";

    public static void main(String[] args) {
        //Створення файла
        try {
            File myLog = new File(filePath);
            if (myLog.createNewFile()) {
                System.out.println("File created: " + myLog.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //запис в log
        try {
            FileWriter myWriter = new FileWriter(filePath);
            myWriter.write("INFO: Starting JuniorCrudServiceApplication using Java 17.0.7\n");
            myWriter.write("DEBUG: User admin created\n");
            myWriter.write("ERROR: Can not connect to server\n");
            myWriter.write("INFO: User logged in\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //Прочитуємо месенджи
        try {
            File readlog = new File(filePath);
            Scanner myReader = new Scanner(readlog);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("Testing INFO");
        filter ("INFO");
        System.out.println("Testing DEBUG");
        filter ("DEBUG");
 }
    public static void filter(String logLevel)
    {
        try {
            File readlog = new File(filePath);
            Scanner myReader = new Scanner(readlog);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (logLevel=="DEBUG") {
                    if (data.substring(0,5).equals("DEBUG")) System.out.println(data);
                }
                if (logLevel=="INFO") {
                    if (data.substring(0,4).equals("INFO")) System.out.println(data);
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
