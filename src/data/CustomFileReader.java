package data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CustomFileReader {

    public static List<String>  read(String path) {

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            return reader.lines().collect(Collectors.toList());

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return new ArrayList<>();
    }
}
