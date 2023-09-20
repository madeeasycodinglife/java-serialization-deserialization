package com.madeeasy;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        // Create an Employee object
        Employee employee = new Employee("Alice", 101);

        // Specify the file path
        String filePath = "E:\\employee.json";

        // Serialize the Employee object to a JSON file
        try (FileOutputStream fos = new FileOutputStream(filePath);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            // Create an ObjectMapper for JSON serialization
            ObjectMapper objectMapper = new ObjectMapper();

            // Convert the Employee object to JSON and write it to the file
            String json = objectMapper.writeValueAsString(employee);
            oos.writeObject(json);
            System.out.println("Employee object serialized to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize the Employee object from the JSON file
        try (FileInputStream fis = new FileInputStream(filePath);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            // Read the JSON string from the file
            String json = (String) ois.readObject();

            // Create an ObjectMapper for JSON deserialization
            ObjectMapper objectMapper = new ObjectMapper();

            // Convert the JSON string back to an Employee object
            Employee deserializedEmployee = objectMapper.readValue(json, Employee.class);

            System.out.println("Employee object deserialized:");
            System.out.println(deserializedEmployee);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}