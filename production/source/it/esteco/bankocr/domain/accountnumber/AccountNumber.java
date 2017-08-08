package it.esteco.bankocr.domain.accountnumber;

import java.util.Arrays;
import java.util.List;

public class AccountNumber {

    private final String chars;
    private final AccountNumberState state;
    private List<AccountNumber> options;

    public AccountNumber(String chars) {
        this.chars = chars;
        if (chars.contains("?")) {
            state = AccountNumberState.ILLEGIBLE;
        } else if (checksum(splitCharacters(chars)) % 11 == 0) {
            state = AccountNumberState.VALID;
        } else {
            state = AccountNumberState.ERROR;
        }
    }

    public AccountNumber(String chars, List<AccountNumber> options) {
        this.chars = chars;
        this.state = AccountNumberState.AMBIGUOUS;
        this.options = options;
    }

    public boolean isIllegible() {
        return AccountNumberState.ILLEGIBLE.equals(state);
    }

    public String asText() {
        return chars;
    }

    public boolean isValid() {
        return AccountNumberState.VALID.equals(state);
    }

    public boolean isAmbiguous() {
        return AccountNumberState.AMBIGUOUS.equals(state);
    }

    public List<AccountNumber> getOptions() {
        return options;
    }

    private List<String> splitCharacters(String chars) {
        return Arrays.asList(chars.split("(?!^)"));
    }

    private int checksum(List<String> chars) {
        if (chars.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(chars.get(0)) *  chars.size() + checksum(chars.subList(1, chars.size()));
    }

    @Override
    public String toString() {
        return "AccountNumber{" +
                "chars='" + chars + '\'' +
                ", state=" + state +
                ", options=" + options +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountNumber that = (AccountNumber) o;

        if (!chars.equals(that.chars)) return false;
        if (state != that.state) return false;
        return options != null ? options.equals(that.options) : that.options == null;
    }

    @Override
    public int hashCode() {
        int result = chars.hashCode();
        result = 31 * result + state.hashCode();
        result = 31 * result + (options != null ? options.hashCode() : 0);
        return result;
    }

}
