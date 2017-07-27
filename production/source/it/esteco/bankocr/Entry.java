package it.esteco.bankocr;

public class Entry {

    private static final String ZERO_CELL =
            " _ " +
            "| |" +
            "|_|";
    private static final String ONE_CELL =
            "   " +
            "  |" +
            "  |";
    private static final String TWO_CELL =
            " _ " +
            " _|" +
            "|_ ";
    private static final String THREE_CELL =
            " _ " +
            " _|" +
            " _|";
    private static final String FOUR_CELL =
            "   " +
            "|_|" +
            "  |";
    private static final String FIVE_CELL =
            " _ " +
            "|_ " +
            " _|";
    private static final String SIX_CELL =
            " _ " +
            "|_ " +
            "|_|";
    private static final String SEVEN_CELL =
            " _ " +
            "  |" +
            "  |";
    private static final String EIGHT_CELL =
            " _ " +
            "|_|" +
            "|_|";
    private static final String NINE_CELL =
            " _ " +
            "|_|" +
            " _|";

    private final String firstLine;
    private final String secondLine;
    private final String thirdLine;

    public Entry(String firstLine, String secondLine, String thirdLine) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.thirdLine = thirdLine;
    }

    public String toAccountNumber() {
        return convert(firstLine, secondLine, thirdLine);
    }

    private String convert(String firstLine, String secondLine, String thirdLine) {
        if (firstLine.isEmpty()) {
            return "";
        } else {
            String cell = firstLine.substring(0, 3) + secondLine.substring(0, 3) + thirdLine.substring(0, 3);
            return cellToDigit(cell) + convert(firstLine.substring(3), secondLine.substring(3), thirdLine.substring(3));
        }
    }

    private String cellToDigit(String cell) {
        switch (cell) {
            case ZERO_CELL:
                return "0";
            case ONE_CELL:
                return "1";
            case TWO_CELL:
                return "2";
            case THREE_CELL:
                return "3";
            case FOUR_CELL:
                return "4";
            case FIVE_CELL:
                return "5";
            case SIX_CELL:
                return "6";
            case SEVEN_CELL:
                return "7";
            case EIGHT_CELL:
                return "8";
            case NINE_CELL:
                return "9";
        }
        return "";
    }

    @Override
    public String toString() {
        return '\n' +
                firstLine + '\n' +
                secondLine + '\n' +
                thirdLine + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entry entry = (Entry) o;

        if (!firstLine.equals(entry.firstLine)) return false;
        if (!secondLine.equals(entry.secondLine)) return false;
        return thirdLine.equals(entry.thirdLine);
    }

    @Override
    public int hashCode() {
        int result = firstLine.hashCode();
        result = 31 * result + secondLine.hashCode();
        result = 31 * result + thirdLine.hashCode();
        return result;
    }
}
