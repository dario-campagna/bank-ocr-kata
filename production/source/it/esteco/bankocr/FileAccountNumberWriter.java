package it.esteco.bankocr;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileAccountNumberWriter {

    private final FileWriter fileWriter;

    public FileAccountNumberWriter(String file) throws IOException {
        fileWriter = new FileWriter(file);
    }

    public void writeAll(List<String> accountNumbers) throws IOException {
        accountNumbers.stream().forEach(accountNumberAsText -> {
            try {
                fileWriter.write(accountNumberAsText + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        fileWriter.flush();
        fileWriter.close();
    }
}
