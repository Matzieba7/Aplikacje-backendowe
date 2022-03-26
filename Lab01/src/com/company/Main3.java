package com.company;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class Main3 {

    public static void main(String[] args) throws IOException {

        int[] array = new int[] {4, 5, 7, 11, 12, 15, 15, 21, 40, 45};
        var index = searchIndex(array, 11); // we want to find index for 11

        System.out.println(index);  // 3
    };

    private static int splitArray(int[] array, int value, int index, int limit) {
        if (index > limit) {
            return -1;
        }
        int point = (int) Math.ceil((limit + index) / 2);
        int entry = array[point];
        if (value < entry) {
            return splitArray(array, value, index, point - 1);
        }
        if (value > entry) {
            return splitArray(array, value, point + 1, limit);
        }
        return point; // value == entry
    }

    public static int searchIndex(int[] array, int value) {
        return splitArray(array, value, 0, array.length - 1);
    }
}
