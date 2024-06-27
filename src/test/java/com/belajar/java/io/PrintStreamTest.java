package com.belajar.java.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class PrintStreamTest {

    @Test
    void testPrintStream() {
        PrintStream stream = System.out;

        stream.println("Halo");
        stream.println("Halo World");
        stream.println("Halo Dunia");
    }

    @Test
    void testPrintStreamFile() {
        Path path = Path.of("print.txt");

        try (OutputStream outputStream = Files.newOutputStream(path);
        PrintStream stream = new PrintStream(outputStream)) {
            stream.println("Hello");
            stream.println("Hello World");
            stream.println("Hello Dunia");
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }
}
