package it.esteco.bankocr.adapters;

import it.esteco.bankocr.domain.Entry;
import it.esteco.bankocr.domain.EntryReader;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class FileEntryReader implements EntryReader {

    private final List<String> lines;

    public FileEntryReader(String filePathAsText) throws IOException {
        FileReader fileReader = new FileReader(new File(filePathAsText));
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        lines = bufferedReader.lines().filter(line -> !line.isEmpty()).collect(Collectors.toList());
        bufferedReader.close();
    }

    @Override
    public Entry readEntry() {
        if (noEntries()) {
            return null;
        } else {
            return new Entry(lines.remove(0), lines.remove(0), lines.remove(0));
        }
    }

    private boolean noEntries() {
        return lines.isEmpty();
    }

}
