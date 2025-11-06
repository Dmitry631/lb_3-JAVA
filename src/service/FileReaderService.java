package service;

import model.*;
import exception.InvalidDataException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class FileReaderService {
    private static final Logger logger = Logger.getLogger(FileReaderService.class.getName());

    public static List<Student> readStudentFromCSV(String filename){
        List<Student> students = new ArrayList<>();
        Logger logger = Logger.getLogger(FileReaderService.class.getName());

        logger.info("Start reading students from file: " + filename);

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] parts = line.split(",");

                    if (parts.length != 6) {
                        throw new InvalidDataException("Incorrect number of fields: " + line);
                    }

                    String name = parts[0].trim();
                    String surname = parts[1].trim();
                    String faculty = parts[2].trim();

                    int course = Integer.parseInt(parts[3].trim());

                    EducationForm form = EducationForm.valueOf(parts[4].trim().toUpperCase());

                    boolean budget = Boolean.parseBoolean(parts[5].trim());

                    Student student = new Student(name, surname, faculty, course, form, budget);
                    students.add(student);
                    logger.info("Student created: " + student);

                } catch (IllegalArgumentException | InvalidDataException e) {
                    logger.severe("Error creating student: " + e.getMessage());
                }
            }

            if (students.isEmpty()) {
                throw new RuntimeException("!!! File is empty: " + filename);
            }

        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("File not found: " + filename);
        } catch (IOException e) {
            logger.severe("IO error reading file: " + filename + ": " + e.getMessage());
        }

        return students;
    }
}
