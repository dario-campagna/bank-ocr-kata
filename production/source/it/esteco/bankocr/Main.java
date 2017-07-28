package it.esteco.bankocr;

import it.esteco.bankocr.adapters.FileEntryReader;
import it.esteco.bankocr.domain.BankOCR;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {

    private static final int INPUT_FILE_PATH_AS_TEXT = 0;
    private static final int OUTPUT_FILE_PATH_AS_TEXT = 1;
    private BankOCR bankOCR;

    public Main() {
        bankOCR = new BankOCR();
    }

    public static void main(String... args) {
        Main main = new Main();
        main.convert(args[INPUT_FILE_PATH_AS_TEXT], args[OUTPUT_FILE_PATH_AS_TEXT]);
    }

    private void convert(String inputFilePathAsText, String outputFilePathAsText) {
        try {
            List accountNumbers = bankOCR.parse(new FileEntryReader(inputFilePathAsText));
            FileWriter outputWriter = new FileWriter(outputFilePathAsText);
            accountNumbers.stream().forEach(accountNumberAsText -> {
                try {
                    outputWriter.write(accountNumberAsText + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            outputWriter.flush();
            outputWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
