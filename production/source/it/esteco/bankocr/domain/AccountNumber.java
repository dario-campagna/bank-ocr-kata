package it.esteco.bankocr.domain;

import java.util.List;

public class AccountNumber {

    private List<Integer> digits;

    public AccountNumber(List<Integer> digits) {
        this.digits = digits;
    }

    public boolean isValid() {
        return checksum(digits) % 11 == 0;
    }

    private int checksum(List<Integer> digits) {
        if (digits.isEmpty()) {
            return 0;
        }
        return digits.get(0) *  digits.size() + checksum(digits.subList(1, digits.size()));
    }
}
