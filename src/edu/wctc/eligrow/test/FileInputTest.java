package edu.wctc.eligrow.test;

import edu.wctc.eligrow.FileInput;

import static org.junit.Assert.*;

public class FileInputTest {
    FileInput file;
    FileInput badFile;
    @org.junit.Before
    public void setUp() throws Exception {
        file = new FileInput("test.txt");
        badFile = new FileInput("asdf.txt");
    }

    @org.junit.After
    public void tearDown() throws Exception {
        file.fileClose();
        badFile.fileClose();
    }

    @org.junit.Test
    public void fileReadLine() {
        assertNotNull("This will return a value", file.fileReadLine());
        assertNull("This will return null", badFile.fileReadLine());
    }
}