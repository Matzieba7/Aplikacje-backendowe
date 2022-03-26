package com.company;
import java.io.*;
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("txt.txt");
        int lenght = (int) file.length();
        try {
            FileInputStream stream = new FileInputStream("txt.txt");
            InputStreamReader reader = new InputStreamReader(stream);
            char[] data = new char[lenght];
            int readBytes = reader.read(data, 0, lenght);
            if (readBytes != lenght) {
                throw new IOException("File reading error (expected" + lenght + "bytes");
            }
            String text = new String(data);
            System.out.println(text);
            reader.close();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
