package com.company;

public class Utilities {

    // returns a char array containing every nth char
    public char[] everyNthChar(char[] sourceArray, int n) {
        if (sourceArray == null || sourceArray.length < n) {
            return sourceArray;
        }
        int returnedLenth = sourceArray.length / n;
        char[] result = new char[returnedLenth];
        int index = 0;

        for (int i = n - 1; i < sourceArray.length; i += n) {
            result[index++] = sourceArray[i];
        }

        return result;
    }

    // removes pairs of the same character that are adjacent
    public String removePairs(String source) {

        // if length is less than 2, there won't be any pairs
        if ( source == null || source.length() < 2) {
            return source;
        }

        StringBuilder sb = new StringBuilder();
        char[] string = source.toCharArray();

        for (int i = 0; i < string.length - 1; i++) {
            if (string[i] != string[i + 1]) {
                sb.append(string[i]);
            }
        }

        // add the final character, which is always safe
        sb.append(string[string.length - 1]);

        return sb.toString();
    }

    // perform a conversion based on some internal business rule
    public int converter(int a, int b) {
        return (a / b) + (a * 30) - 2;
    }

    public String nullIfOddLength(String source) {
        if (source.length() % 2 == 0) {
            return source;
        }
        return null;
    }

}
