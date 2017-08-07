package it.esteco.bankocr.domain;

import java.util.ArrayList;
import java.util.List;

public class BankOCR {
    public List<AccountNumber> parse(EntryReader reader) {
        List<AccountNumber> accountNumbers = new ArrayList<>();
        Entry entry = reader.readEntry();
        while (entry != null) {
            accountNumbers.add(new AccountNumber(entry.asText()));
            entry = reader.readEntry();
        }
        return accountNumbers;
    }
}
