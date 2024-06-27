package com.belajar.java.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class ObjectStreamTest {

    @Test
    void testSavePerson() {
        Person person = new Person();
        person.setId("1");
        person.setName("Arbi");
        Path path = Path.of("arbi.person");

        try (OutputStream stream = Files.newOutputStream(path);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream((stream))) {
            objectOutputStream.writeObject(person);
            objectOutputStream.flush();
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }

    @Test
    void testGetPerson() {
        Path path = Path.of("arbi.person");

        try (InputStream stream = Files.newInputStream(path);
             ObjectInputStream objectInputStream = new ObjectInputStream(stream)) {
            Person person = (Person) objectInputStream.readObject();
            Assertions.assertEquals("1", person.getId());
            Assertions.assertEquals("Arbi", person.getName());
        } catch (IOException | ClassNotFoundException e) {
            Assertions.fail(e);
        }
    }
}
