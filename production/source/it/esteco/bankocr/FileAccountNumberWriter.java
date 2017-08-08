package it.esteco.bankocr;

import it.esteco.bankocr.domain.accountnumber.AccountNumber;
import it.esteco.bankocr.domain.accountnumber.AccountNumberFormatter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileAccountNumberWriter {

    private final FileWriter fileWriter;
    private AccountNumberFormatter formatter;

    public FileAccountNumberWriter(String file, AccountNumberFormatter formatter) throws IOException {
        fileWriter = new FileWriter(file);
        this.formatter = formatter;
    }

    public void writeAll(List<AccountNumber> accountNumbers) throws IOException {
        accountNumbers.stream().forEach(accountNumber -> {
            try {
                fileWriter.write(formatter.format(accountNumber) + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        fileWriter.flush();
        fileWriter.close();
    }
}
