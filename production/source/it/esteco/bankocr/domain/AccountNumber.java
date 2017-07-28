package it.esteco.bankocr.domain;

import java.util.Arrays;
import java.util.List;

public class AccountNumber {

    private final String chars;

    public AccountNumber(String chars) {
        this.chars = chars;
    }

    public boolean isIllegible() {
        return chars.contains("?");
    }

    public boolean isValid() {
        return !isIllegible() && checksum(Arrays.asList(chars.split("(?!^)"))) % 11 == 0;
    }

    private int checksum(List<String> chars) {
        if (chars.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(chars.get(0)) *  chars.size() + checksum(chars.subList(1, chars.size()));
    }

    @Override
    public String toString() {
        return chars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountNumber that = (AccountNumber) o;

        return chars.equals(that.chars);
    }

    @Override
    public int hashCode() {
        return chars.hashCode();
    }
}
