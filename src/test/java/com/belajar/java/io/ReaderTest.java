package com.belajar.java.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReaderTest {

    @Test
    void testReader() {
        Path path = Path.of("output.txt");

        try (Reader reader = Files.newBufferedReader(path)){
            StringBuilder builder = new StringBuilder();
            int data;
            int counter = 0;
            while ((data = reader.read()) != -1) {
                builder.append((char) data);
                counter++;
            }
            System.out.println(builder.toString());
            System.out.println(counter);
        } catch (IOException e){
            Assertions.fail(e);
        }
    }

    @Test
    void testReaderChars() {
        Path path = Path.of("output.txt");

        try (Reader reader = Files.newBufferedReader(path)){
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[1024];
            int data;
            int counter = 0;
            while ((data = reader.read(buffer)) != -1) {
                builder.append(buffer, 0, data);
                counter++;
            }
            System.out.println(builder.toString());
            System.out.println(counter);
        } catch (IOException e){
            Assertions.fail(e);
        }
    }
}
