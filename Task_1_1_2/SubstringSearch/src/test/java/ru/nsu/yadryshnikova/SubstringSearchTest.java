package ru.nsu.yadryshnikova;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Random;

class SubstringSearchTest {
    private String testFilename = "input_test.txt";

    void writeTestFile(String text) throws IOException {
        FileWriter fileWriter = new FileWriter(testFilename);
        fileWriter.write(text);
        fileWriter.close();

    }

    @Test
    void substringSearch_noIncludes() throws IOException {
        char[] pattern = "can't".toCharArray();
        String text = "Just do it! Make your dreams come true. Do it!";
        Integer[] expected = {};

        writeTestFile(text);

        FileInputStream fileInputStream = new FileInputStream(testFilename);

        SubstringSearch patternIncludes = new SubstringSearch(fileInputStream);
        List<Integer> resList = patternIncludes.search(pattern);

        Assertions.assertArrayEquals(expected, resList.toArray());
    }

    @Test
    void substringSearch_included() throws IOException {
        char[] pattern = "dreams".toCharArray();
        String text = """
                Sweet dreams are made of this
                Who am I to disagree?
                Travel the world and the seven seas
                Everybody's looking for something
                Some of them want to use you
                Some of them want to get used by you
                Some of them want to abuse you
                Some of them want to be abused""";
        Integer[] expected = {6};

        writeTestFile(text);

        FileInputStream fileInputStream = new FileInputStream(testFilename);

        SubstringSearch patternIncludes = new SubstringSearch(fileInputStream);
        List<Integer> resList = patternIncludes.search(pattern);

        Assertions.assertArrayEquals(expected, resList.toArray());
    }

    @Test
    void substringSearch_multipleInclusions() throws IOException {
        char[] pattern = "dance".toCharArray();
        String text = "I'm never gonna dance again. Guilty feet have got no rhythm... So I'm never gonna dance again";
        Integer[] expected = {16, 82};

        writeTestFile(text);

        FileInputStream fileInputStream = new FileInputStream(testFilename);

        SubstringSearch patternIncludes = new SubstringSearch(fileInputStream);
        List<Integer> resList = patternIncludes.search(pattern);

        Assertions.assertArrayEquals(expected, resList.toArray());
    }

    @Test
    void substringSearch_intersection() throws IOException {
        char[] pattern = "lol".toCharArray();
        String text = "lololol";
        Integer[] expected = {0, 2, 4};

        writeTestFile(text);

        FileInputStream fileInputStream = new FileInputStream(testFilename);

        SubstringSearch patternIncludes = new SubstringSearch(fileInputStream);
        List<Integer> resList = patternIncludes.search(pattern);

        Assertions.assertArrayEquals(expected, resList.toArray());
    }

    @Test
    void substringSearch_extraSymbols() throws IOException {
        char[] pattern = " `'l;/v: :'/?, :) u'".toCharArray();
        String text = "  `; :'( kidding ;)) `'l;/v: :'/?, :) u' a;d,;/7&*@/";
        Integer[] expected = {20};

        writeTestFile(text);

        FileInputStream fileInputStream = new FileInputStream(testFilename);

        SubstringSearch patternIncludes = new SubstringSearch(fileInputStream);
        List<Integer> resList = patternIncludes.search(pattern);

        Assertions.assertArrayEquals(expected, resList.toArray());
    }

    @Test
    void substringSearch_bigText() throws IOException {
        char[] pattern = "some pattern".toCharArray();
        List<Integer> expected = new ArrayList<>();
        Random r = new Random();
        char[] real = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        char[] decrypted = new char[10000];
        FileWriter fileWriter = new FileWriter(testFilename);
        for (int i = 0; i < 10000; i++) {
            decrypted[i] = real[r.nextInt(26)];
        }
        for (int i = 0; i < 10000; i++) {
            fileWriter.write(decrypted[i]);
            fileWriter.write(pattern);
            expected.add((i * pattern.length) + i + 1);
        }

        fileWriter.close();

        FileInputStream fileInputStream = new FileInputStream(testFilename);

        SubstringSearch patternIncludes = new SubstringSearch(fileInputStream);
        List<Integer> resList = patternIncludes.search(pattern);

        Assertions.assertArrayEquals(expected.toArray(), resList.toArray());
    }
}