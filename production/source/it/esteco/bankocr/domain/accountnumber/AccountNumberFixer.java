package it.esteco.bankocr.domain.accountnumber;

import it.esteco.bankocr.domain.cell.CellFixer;
import it.esteco.bankocr.domain.entry.Entry;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AccountNumberFixer {

    private List<CellFixer> fixers;

    public AccountNumberFixer(List<CellFixer> fixers) {
        this.fixers = fixers;
    }

    public AccountNumber fix(Entry entryToFix) {
        List<AccountNumber> validNumbers = generateValidAccountNumbersFrom(entryToFix);
        if (noValidNumberFound(validNumbers)) {
            return new AccountNumber(entryToFix.asText());
        } else if (exactlyOneValidNumberFound(validNumbers)) {
            return validNumbers.get(0);
        } else {
            return new AccountNumber(entryToFix.asText(), validNumbers);
        }
    }

    private List<AccountNumber> generateValidAccountNumbersFrom(Entry entryToFix) {
        List<AccountNumber> numbers = new ArrayList<>();
        for (CellFixer fixer : fixers) {
            List<Entry> entries = entryToFix.fixWith(fixer);
            for (Entry entry : entries) {
                numbers.add(new AccountNumber(entry.asText()));
            }
        }
        return numbers.stream().filter(AccountNumber::isValid).collect(Collectors.toList());
    }

    private boolean exactlyOneValidNumberFound(List<AccountNumber> validNumbers) {
        return validNumbers.size() == 1;
    }

    private boolean noValidNumberFound(List<AccountNumber> validNumbers) {
        return validNumbers.isEmpty();
    }
}
