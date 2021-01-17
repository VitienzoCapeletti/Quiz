package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Stream;

public class CustomFileReader {

    public static Stream<String> read(String path) {

        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            return reader.lines();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return Stream.empty();
    }
}
