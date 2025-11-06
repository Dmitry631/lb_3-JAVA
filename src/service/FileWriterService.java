package service;

import model.CSVWritable;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

public class FileWriterService {
    private static final Logger logger = Logger.getLogger((FileWriterService.class.getName()));

    public static <T extends CSVWritable> void writeToCSV(String filename, List<T> objects){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for(T obj : objects){
                writer.write(obj.toCSV());
                writer.newLine();
            }
            logger.info("File " + filename + " write (count:" + objects.size() + " )");
        } catch (IOException e) {
            logger.severe("Error write. File: " + filename + ": " + e.getMessage());
        }
    }

    public static <T extends CSVWritable> void writeToCSV(String filename, T object){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(object.toCSV());
            writer.newLine();
            logger.info("File " + filename + " write\n" + "( " + object.toString() + ")");
        } catch (IOException e) {
            logger.severe("Error write. File: " + filename + ": " + e.getMessage());
        }
    }
}
