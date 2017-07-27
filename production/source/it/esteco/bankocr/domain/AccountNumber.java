package it.esteco.bankocr.domain;

import java.util.Arrays;
import java.util.List;

public class AccountNumber {

    private String chars;

    public AccountNumber(String chars) {
        this.chars = chars;
    }

    public boolean isValid() {
        return checksum(Arrays.asList(chars.split("(?!^)"))) % 11 == 0;
    }

    private int checksum(List<String> chars) {
        if (chars.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(chars.get(0)) *  chars.size() + checksum(chars.subList(1, chars.size()));
    }
}
