package com.belajar.java.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ManipulationFileTest {

    @Test
    void testFileManipulate() throws IOException {
        Path path = Path.of("files.txt");
        Files.createFile(path);
        Assertions.assertTrue(Files.exists(path));

        Files.delete(path);
        Assertions.assertFalse(Files.exists(path));
    }
}
