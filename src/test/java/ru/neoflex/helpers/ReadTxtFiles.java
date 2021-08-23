package ru.neoflex.helpers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadTxtFiles {

    public String read(String path) {
        try {
            return Files.lines(Paths.get(path)).reduce("", String::concat);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
