package it.esteco.bankocr;

import java.io.*;

public class FileEntryReader implements EntryReader {
    private final BufferedReader bufferedReader;

    public FileEntryReader(String filePathAsText) throws FileNotFoundException {
        FileReader fileReader = new FileReader(new File(filePathAsText));
        bufferedReader = new BufferedReader(fileReader);
    }

    @Override
    public Entry readEntry() throws Exception {
        String firstLine = bufferedReader.readLine();
        if (firstLine != null) {
            String secondLine = bufferedReader.readLine();
            String thirdLine = bufferedReader.readLine();
            skipBlankLine();
            return new Entry(firstLine, secondLine, thirdLine);
        } else {
            return null;
        }
    }

    private void skipBlankLine() throws IOException {
        bufferedReader.readLine();
    }
}
