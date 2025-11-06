package model;

import util.Utils;

public record Student (String name, String surname, String faculty, int course, EducationForm form, boolean budget) implements CSVWritable{
    public Student{
        if(!Utils.checkNamedData(name))
            throw new IllegalArgumentException("Incorrect student name. Try again.");
        if(!Utils.checkNamedData(surname))
            throw new IllegalArgumentException("Incorrect student surname. Try again.");
        if(!Utils.checkNumber(course))
            throw new IllegalArgumentException("Incorrect course. Try again.");
        if (faculty == null || faculty.trim().isEmpty())
            throw new IllegalArgumentException("Faculty cannot be empty.");
    }

    public String toCSV(){
        return name + "," + surname + "," + faculty + "," + course + "," + form + "," + budget;
    }
}



