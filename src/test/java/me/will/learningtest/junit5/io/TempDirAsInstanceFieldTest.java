package me.will.learningtest.junit5.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TempDirAsInstanceFieldTest {
    @TempDir
    File tmpDir;

    @Test
    void givenFieldWithTempDirectoryFile_whenWriteToFile_thenContentIsCorrect() throws IOException {
        assertTrue(tmpDir.isDirectory());

        File letters = new File(tmpDir, "letters.txt");
        System.out.println(letters.getAbsolutePath());
        List<String> lines = Arrays.asList("x", "y", "z");
        Files.write(letters.toPath(), lines);

        assertAll(
                () -> assertTrue(Files.exists(letters.toPath())),
                () -> assertLinesMatch(lines, Files.readAllLines(letters.toPath()))
        );
    }
}
