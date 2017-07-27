package it.esteco.bankocr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankOCR {
    public List<String> parse(EntryReader reader) {
        try {
            List<String> accountNumbers = new ArrayList<>();
            Entry entry = reader.readEntry();
            while (entry != null) {
                accountNumbers.add(entry.toAccountNumber());
                entry = reader.readEntry();
            }
            return accountNumbers;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Arrays.asList();
    }
}
