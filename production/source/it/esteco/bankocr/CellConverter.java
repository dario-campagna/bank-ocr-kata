package it.esteco.bankocr;

public class CellConverter {

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

    public static String toDigit(String cell) {
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

}
