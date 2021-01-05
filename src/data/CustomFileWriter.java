package data;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CustomFileWriter {

    public static <T> void write(String path, List<T> lines) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (Object line : lines) {
                bw.write(line.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
