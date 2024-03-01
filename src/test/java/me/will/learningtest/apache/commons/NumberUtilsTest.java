package me.will.learningtest.apache.commons;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NumberUtilsTest {
    @Test
    public void testIsNumber() {
        assertTrue(NumberUtils.isDigits("100"));
        assertTrue(NumberUtils.isCreatable("-100"));
        assertTrue(NumberUtils.isCreatable("1.01"));
    }

    @Test
    public void testIsNumber_withQualifier() {
        assertTrue(NumberUtils.isCreatable("0x100"));
        assertTrue(NumberUtils.isCreatable("-100L"));
    }
}
