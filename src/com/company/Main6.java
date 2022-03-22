package com.company;

import java.io.IOException;

public class Main6 {

    public static void main(String[] args) throws IOException {
        String string = "line/line2";
        String[] parts = string.split("/");

        for (int i = 0; i < parts.length; i++) {
            System.out.println( "Line " +  Integer.toString(i) + ":" + parts[i]);
        }
    }
}
