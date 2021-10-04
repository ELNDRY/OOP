package ru.nsu.yadryshnikova;

import java.io.InputStream;
import java.io.IOException;
import java.lang.System;
import java.nio.charset.StandardCharsets;
import java.util.*;

 public class SubstringSearch {

    private final InputStream inputStream;

    public SubstringSearch(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public List<Integer> search(char[] pattern) throws IOException {
        List<Integer> foundIndexes = new ArrayList<>();

        char[] zFuncText = new char[pattern.length * 11];
        System.arraycopy(pattern, 0, zFuncText, 0, pattern.length);
        readTo(zFuncText, pattern.length);

        int indexOffset = 0;
        int[] zFuncValue;
        while (true) {
            zFuncValue = getzFunctionArray(zFuncText);
            for (int i = pattern.length; i < zFuncText.length - pattern.length + 1; i++) {
                if (zFuncValue[i] >= pattern.length) {
                    foundIndexes.add(i - pattern.length + indexOffset);
                }
                if (zFuncText[i] == '\0') {
                    return foundIndexes;
                }
            }
            System.arraycopy(zFuncText, zFuncText.length - pattern.length + 1, zFuncText, pattern.length, pattern.length - 1);
            readTo(zFuncText, 2 * pattern.length - 1);
            indexOffset += pattern.length * (11 - 2) + 1;

        }
    }
    // returns array z[] where z[i] is z-function of str[i]
    private int[] getzFunctionArray(char[] str) {
        int[] z = new int[str.length];
        int left = 0;
        int right = 0;

        for (int i = 1; i < str.length; i++) {
            if (right >= i) {
                z[i] = Math.min(right - i + 1, z[i - left]);
            }
            while (i + z[i] < str.length && str[z[i]] == str[i + z[i]])
                z[i]++;
        }
        return z;
    }
     private void readTo(char[] dest, int destPos) throws IOException {
         int toRead = dest.length - destPos;

         String str = new String(inputStream.readNBytes(toRead), StandardCharsets.UTF_8);
         System.arraycopy(str.toCharArray(), 0, dest, destPos, str.length());
         if (str.length() < toRead) {
             dest[destPos + str.length()] = '\0';
         }
     }
}








