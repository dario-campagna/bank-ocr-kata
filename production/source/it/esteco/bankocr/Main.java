package it.esteco.bankocr;

import it.esteco.bankocr.adapters.FileEntryReader;
import it.esteco.bankocr.domain.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

    private static final int INPUT_FILE_PATH_AS_TEXT = 0;
    private static final int OUTPUT_FILE_PATH_AS_TEXT = 1;
    private BankOCR bankOCR;

    public Main() {
        bankOCR = new BankOCR(new AccountNumberFixer(Arrays.asList(new PipeCellFixer(), new UnderscoreCellFixer())));
    }

    public static void main(String... args) {
        Main main = new Main();
        main.convert(args[INPUT_FILE_PATH_AS_TEXT], args[OUTPUT_FILE_PATH_AS_TEXT]);
    }

    private void convert(String inputFilePathAsText, String outputFilePathAsText) {
        try {
            List<AccountNumber> accountNumbers = bankOCR.parse(new FileEntryReader(inputFilePathAsText));
            FileAccountNumberWriter accountNumberWriter = new FileAccountNumberWriter(outputFilePathAsText, new AccountNumberFormatter());
            accountNumberWriter.writeAll(accountNumbers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
