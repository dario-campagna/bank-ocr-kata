package it.esteco.bankocr.domain;

import it.esteco.bankocr.domain.accountnumber.AccountNumber;
import it.esteco.bankocr.domain.accountnumber.AccountNumberFixer;
import it.esteco.bankocr.domain.entry.Entry;
import it.esteco.bankocr.domain.entry.EntryReader;

import java.util.ArrayList;
import java.util.List;

public class BankOCR {

    private AccountNumberFixer fixer;

    public BankOCR(AccountNumberFixer fixer) {
        this.fixer = fixer;
    }

    public List<AccountNumber> parse(EntryReader reader) {
        List<AccountNumber> accountNumbers = new ArrayList<>();
        Entry entry = reader.readEntry();
        while (entry != null) {
            accountNumbers.add(entryToAccountNumber(entry));
            entry = reader.readEntry();
        }
        return accountNumbers;
    }

    private AccountNumber entryToAccountNumber(Entry entry) {
        AccountNumber accountNumber = new AccountNumber(entry.asText());
        if (accountNumber.isValid()) {
            return accountNumber;
        } else {
            return fixer.fix(entry);
        }
    }
}
