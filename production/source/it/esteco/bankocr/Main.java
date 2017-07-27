package it.esteco.bankocr;

import java.io.IOException;
import java.util.List;

public class Main {

    public static final int FILE_PATH_AS_TEXT = 0;
    private BankOCR bankOCR;

    public Main() {
        bankOCR = new BankOCR();
    }

    public static void main(String... args) {
        Main main = new Main();
        main.parse(args[FILE_PATH_AS_TEXT]);
    }

    private void parse(String filePathAsText) {
        try {
            List accountNumbers = bankOCR.parse(new FileEntryReader(filePathAsText));
            accountNumbers.stream().forEach(accountNumberAsText -> System.out.println(accountNumberAsText));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
