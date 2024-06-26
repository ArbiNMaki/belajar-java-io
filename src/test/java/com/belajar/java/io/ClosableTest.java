package com.belajar.java.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class ClosableTest {

    @Test
    void testCloseIO() {
        Path path = Path.of("pom.xml");
        InputStream inputStream = null;
        try {
            inputStream = Files.newInputStream(path);
        } catch (IOException e) {
            Assertions.fail(e);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    Assertions.fail(e);
                }
            }
        }
    }

    @Test
    void testCloseIOWithResource() {
        Path path = Path.of("pom.xml");
        try (InputStream _ = Files.newInputStream(path);
             InputStream _ = Files.newInputStream(path);
             InputStream _ = Files.newInputStream(path);
        ) {
            // Do something
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }
}
