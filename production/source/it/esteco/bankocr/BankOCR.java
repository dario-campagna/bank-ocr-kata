package it.esteco.bankocr;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;

public class BankOCR {
    public String parse(URL fileURL) {
        try {
            FileReader fileReader = new FileReader(new File(fileURL.toURI()));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Entry entry = new Entry(bufferedReader.readLine(), bufferedReader.readLine(), bufferedReader.readLine());
            return entry.toAccountNumber();
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
