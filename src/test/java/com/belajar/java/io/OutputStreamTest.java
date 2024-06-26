package com.belajar.java.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class OutputStreamTest {

    @Test
    void testOutputStream() {
        Path path = Path.of("output.txt");

        try (OutputStream stream = Files.newOutputStream(path)) {
            for (int i = 0; i < 100; i++) {
                stream.write("Halo Dunia\n".getBytes());
                stream.flush();
            }
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }

    @Test
    void testAppendWithOpenOption() {
        Path path = Path.of("append.txt");

        try (OutputStream stream = Files.newOutputStream(path,
                StandardOpenOption.CREATE, StandardOpenOption.APPEND)) {
            for (int i = 0; i < 100; i++) {
                stream.write("Halo Dunia\n".getBytes());
                stream.flush();
            }
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }
}
