package me.will.learningtest.junit5.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TempDirAsParamTest {
    @Test
    void givenTestMethodWithTempDirectory_whenWriteToFile_thenContentIsCorrect(@TempDir Path tmpDir) throws IOException {
        Path numbers = tmpDir.resolve("numbers.txt");

        List<String> lines = Arrays.asList("1", "2", "3");
        Files.write(numbers, lines);

        assertAll(
                () -> assertTrue(Files.exists(numbers)),
                () -> assertLinesMatch(lines, Files.readAllLines(numbers))
        );
    }
}
