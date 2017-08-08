package it.esteco.bankocr.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AccountNumberFixer {

    private List<CellFixer> fixers;

    public AccountNumberFixer(List<CellFixer> fixers) {
        this.fixers = fixers;
    }

    public AccountNumber fix(Entry entryToFix) {
        List<AccountNumber> numbers = generateAccountNumbers(entryToFix);
        List<AccountNumber> validNumbers = numbers.stream().filter(AccountNumber::isValid).collect(Collectors.toList());
        if (validNumbers.size() == 1) {
            return validNumbers.get(0);
        } else {
            return new AccountNumber(entryToFix.asText(), validNumbers);
        }
    }

    private List<AccountNumber> generateAccountNumbers(Entry entryToFix) {
        List<AccountNumber> numbers = new ArrayList<>();
        for (CellFixer fixer : fixers) {
            List<Entry> entries = entryToFix.fixWith(fixer);
            for (Entry entry : entries) {
                numbers.add(new AccountNumber(entry.asText()));
            }
        }
        return numbers;
    }
}
