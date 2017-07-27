package it.esteco.bankocr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileEntryReader implements EntryReader {
    private final BufferedReader bufferedReader;

    public FileEntryReader(String filePathAsText) throws FileNotFoundException {
        FileReader fileReader = new FileReader(new File(filePathAsText));
        bufferedReader = new BufferedReader(fileReader);
    }

    @Override
    public Entry readEntry() throws Exception {
        return new Entry(bufferedReader.readLine(), bufferedReader.readLine(), bufferedReader.readLine());
    }
}
