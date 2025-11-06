package test;

import model.*;
import service.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class Test {
    private static final Logger logger = Logger.getLogger((Test.class.getName()));

    public static void showSaveCSV(){
        String filename = "students.csv";
        Student[] students = new Student[]{
                new Student("Ivan", "Petrenko", "Math", 2, EducationForm.FULL_TIME, true),
                new Student("Mariya", "Ivanenko", "Pholologcal", 1, EducationForm.FULL_TIME, false),
                new Student("Andrew", "Covalchuk", "Physical Education", 4, EducationForm.CORRESPONDENCE, true),
                new Student("Olena", "Branik", "Juristical", 3, EducationForm.INDIVIDUAL, false),
                new Student("Sergii", "Melnik", "Economic", 2, EducationForm.FULL_TIME, true)
        };
        Object[] objects = new Object[]{students};


        List<CSVWritable> writableList = new ArrayList<>();
        writableList.addAll(Arrays.asList(students));
        FileWriterService.writeToCSV(filename, writableList);
    }


    public static void readFromCSV(String filename){
        List<Student> students = FileReaderService.readStudentFromCSV(filename);
        logger.info("Total valid drivers read: " + students.size());
        for(Student s : students)
            System.out.println(s);

    }

    public static void showErrors(){
        System.out.println("Incorrect data");
        FileReaderService.readStudentFromCSV("incorrect.csv");

        System.out.println("Try read empty file.");
        FileReaderService.readStudentFromCSV("empty.csv");



    }
}
