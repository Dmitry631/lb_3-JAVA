package main;

import model.EducationForm;
import model.Student;

import test.Test;




public class Main {
    public static void main(String[] argv){
        Test.showSaveCSV();
        Test.readFromCSV("students.csv");
        Test.showErrors();
    }
}
