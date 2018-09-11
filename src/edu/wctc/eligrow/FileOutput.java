package edu.wctc.eligrow;

import java.io.*;

/**
 * Created by mgreen14 on 12/27/17.
 * @version 1.0
 */
public class FileOutput {

    Writer out = null;
    private String fileName;

    /**
     * Outputs file line by line
     * @param fileName String: Name of file
     */
    public FileOutput(String fileName) {
        this.fileName = fileName;
        try {
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
        }
        catch(FileNotFoundException e) {
            System.out.println("File Open Error: " + fileName + " "  + e);
        }
    }

    /**
     * Writes to file line by line
     * @param line String: Desired line to write to file
     */
    public void fileWrite(String line) {
        try {
            out.write(line+"\n");
        }
        catch(Exception e) {
            System.out.println("File Write Error: " + fileName + " "  + e);
        }
    }

    /**
     * Closes the file
     */
    public void fileClose() {
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}