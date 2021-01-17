package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CustomFileWriter {

    public static <T> void write(String path, T line) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write(line.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
