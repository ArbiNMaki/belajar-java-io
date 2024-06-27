package com.belajar.java.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriterTest {

    @Test
    void testWrite() {
        Path path = Path.of("writer.txt");

        try (Writer stream = Files.newBufferedWriter(path)) {
            for (int i = 0; i < 100; i++) {
                stream.write("Ohayo Sekai\n");
                stream.flush();
            }
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }
}
