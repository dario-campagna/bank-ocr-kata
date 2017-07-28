package it.esteco.bankocr.domain;

public class AccountNumberFormatter {
    public String format(AccountNumber accountNumber) {
        return accountNumber.toString() + status(accountNumber);
    }

    private String status(AccountNumber accountNumber) {
        if (accountNumber.isValid()) {
            return "";
        } else if (accountNumber.isIllegible()) {
            return " ILL";
        } else {
            return " ERR";
        }
    }
}
