package com.example.platformerplain.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This class is used to read and write text files.
 * for example:
 * it reads the content of a text file, or writes content to a file:
 * .
 * usage:
 * File.read("path/to/file.txt");
 * File.write("path/to/file.txt", "content to write");
 */
public class File {

    /**
     * Reads the content of a text file from the specified path.  
     *
     * @param path the path to the file to be read  
     * @return the content of the file as a String  
     * @throws IOException if an error occurs while reading the file  
     */
    public static String read(String path) throws IOException {
        // Convert the string path to a Path object  
        Path filePath = Paths.get(path);
        // Read all bytes from the file and convert to String  
        return Files.readString(filePath);
    }

    /**
     * Writes the specified content to a text file at the given path.  
     *
     * @param path    the path where the content should be written  
     * @param content the content to write to the file  
     * @throws IOException if an error occurs while writing to the file  
     */
    public static void write(String path, String content) throws IOException {
        // Convert the string path to a Path object  
        Path filePath = Paths.get(path);
        // Write content to the file, creating it if it doesn't exist  
        Files.writeString(filePath, content);
    }
}