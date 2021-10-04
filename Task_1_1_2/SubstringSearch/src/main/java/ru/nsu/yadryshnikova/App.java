package ru.nsu.yadryshnikova;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.nextLine();
        String pattern = scanner.nextLine();

        FileInputStream fileInputStream = new FileInputStream(filename);

        SubstringSearch patternFound = new SubstringSearch(fileInputStream);
        List<Integer> resList = patternFound.search(pattern.toCharArray());
        for (Integer x : resList) {
            System.out.print(x + " ");
        }
    }
}
