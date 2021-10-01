package ru.nsu.yadryshnikova;

import java.io.Reader;
import java.util.Arrays;
import java.util.ArrayList;

public class SubstringSearch {
    // returns array z[] where z[i] is z-function of s[i]
    private int[] zFunction(char[] str, int strlen) {
        int[] z = new int[strlen];

        int left = 0;
        int right = 0;

        for (int i = 1; i < strlen; i++) {

            if ( right >= i) {
               z[i] = Math.min(right - i, z[i - left]);
            }
            while (i + z[i] < strlen && str[z[i]] == str[i + z[i]]) {
                ++z[i];
            }
            if (i + z[i] - 1 > right) {
                left = i;
                right = i + z[i];
            }
        }

        return (z);
    }

    public ArrayList<Integer> find(Reader input, char[] pattern) {

        int patternlen = pattern.length;

        int buflen = patternlen * 10;
        char[] buf = new char[buflen];

        int strlen = patternlen + buflen + 1;
        char[] str = new char[strlen];

        ArrayList<Integer> answer = new ArrayList<>(0);

        System.arraycopy(pattern, 0, str, 0, patternlen);
        str[patternlen] = '~';

        try {
            int cnt;
            int iter = 0;
            while (true) {
                if (iter == 0) {
                    cnt = input.read(buf);
                    if (cnt == -1) {
                        break;
                    }
                }

                System.arraycopy(buf, 0, str, patternlen + 1, buflen);
                int[] result = zFunction(str, strlen);

                int lastIndex = 0;
                for (int i = patternlen + 1; i < strlen; i++) {
                    if (result[i] == patternlen) {
                        lastIndex = i - (patternlen + 1);
                        answer.add(iter * buflen + lastIndex);
                    }
                }

                int shift = lastIndex + 2 * patternlen + 1;
                System.arraycopy(str, shift, str, patternlen + 1, strlen - shift);


                Arrays.fill(buf, '\0');
                cnt = input.read(buf);
                if (cnt == -1) {
                    break;
                }

                System.arraycopy(buf, 0, str, strlen - (lastIndex + patternlen), (lastIndex + patternlen));
                result = zFunction(str, strlen);

                for (int i = patternlen + 1; i < strlen; i++) {
                    if (result[i] == patternlen) {
                        answer.add(iter * buflen + i + lastIndex + 1);
                    }
                }

                iter++;
            }
            input.close();

        } catch (Exception e) {
            e.getStackTrace();
        }
        return (answer);
    }
}