package it.esteco.bankocr;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class BankOCR {
    public List parse(URL fileURL) {
        try {
            FileReader fileReader = new FileReader(new File(fileURL.toURI()));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Entry entry = new Entry(bufferedReader.readLine(), bufferedReader.readLine(), bufferedReader.readLine());
            return Arrays.asList(entry.toAccountNumber());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
