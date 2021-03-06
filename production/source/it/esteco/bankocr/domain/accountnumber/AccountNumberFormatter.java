package it.esteco.bankocr.domain.accountnumber;

import java.util.List;

public class AccountNumberFormatter {

    public String format(AccountNumber accountNumber) {
        return accountNumber.asText() + status(accountNumber) + options(accountNumber);
    }

    private String status(AccountNumber accountNumber) {
        if (accountNumber.isValid()) {
            return "";
        } else if (accountNumber.isIllegible()) {
            return " ILL";
        } else if (accountNumber.isAmbiguous()) {
            return " AMB";
        } else {
            return " ERR";
        }
    }

    private String options(AccountNumber accountNumber) {
        if (accountNumber.isAmbiguous()) {
            return formatOptions(accountNumber.getOptions());
        } else {
            return "";
        }
    }

    private String formatOptions(List<AccountNumber> options) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" ['" + options.get(0).asText() + "'");
        for (AccountNumber number : options.subList(1, options.size())) {
            stringBuilder.append(", '" + number.asText() + "'");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
