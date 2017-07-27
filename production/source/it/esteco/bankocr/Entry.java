package it.esteco.bankocr;

public class Entry {

    private static final String ZERO_CELL =
            " _ " +
            "| |" +
            "|_|";

    private final String firstLine;
    private final String secondLine;
    private final String thirdLine;

    public Entry(String firstLine, String secondLine, String thirdLine) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.thirdLine = thirdLine;
    }

    public String toAccountNumber() {
        return convert(firstLine, secondLine, thirdLine, 0);
    }

    private String convert(String firstLine, String secondLine, String thirdLine, int i) {
        if (firstLine.isEmpty()) {
            return "";
        } else {
            String cell = firstLine.substring(i, i + 3) + secondLine.substring(i, i + 3) + thirdLine.substring(i, i + 3);
            return cellToDigit(cell) + convert(firstLine.substring(i + 3), secondLine.substring(i + 3), thirdLine.substring(i + 3), i++);
        }
    }

    private String cellToDigit(String cell) {
        return ZERO_CELL.equals(cell) ? "0" : "1";
    }
}
