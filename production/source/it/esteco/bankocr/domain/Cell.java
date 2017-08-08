package it.esteco.bankocr.domain;

public class Cell {

    public static final String ZERO_CELL_AS_STRING =
                    " _ " +
                    "| |" +
                    "|_|";
    public static final String ONE_CELL_AS_STRING =
                    "   " +
                    "  |" +
                    "  |";
    public static final String TWO_CELL_AS_STRING =
                    " _ " +
                    " _|" +
                    "|_ ";
    public static final String THREE_CELL_AS_STRING =
                    " _ " +
                    " _|" +
                    " _|";
    public static final String FOUR_CELL_AS_STRING =
                    "   " +
                    "|_|" +
                    "  |";
    public static final String FIVE_CELL_AS_STRING =
                    " _ " +
                    "|_ " +
                    " _|";
    public static final String SIX_CELL_AS_STRING =
                    " _ " +
                    "|_ " +
                    "|_|";
    public static final String SEVEN_CELL_AS_STRING =
                    " _ " +
                    "  |" +
                    "  |";
    public static final String EIGHT_CELL_AS_STRING =
                    " _ " +
                    "|_|" +
                    "|_|";
    public static final String NINE_CELL_AS_STRING =
                    " _ " +
                    "|_|" +
                    " _|";
    private static final String PIPE = "|";
    private static final String SPACE = " ";
    public static final String UNDERSCORE = "_";

    private final String cellAsString;

    public Cell(String cellAsString) {
        this.cellAsString = cellAsString;
    }

    public Cell addTopLeftPipe() {
        return putInTopLeftPosition(PIPE);
    }

    public Cell addTopRightPipe() {
        return putInTopRightPosition(PIPE);
    }

    public Cell addBottomLeftPipe() {
        return putInBottomLeftPosition(PIPE);
    }

    public Cell addBottomRightPipe() {
        return putInBottomRightPosition(PIPE);
    }

    public Cell removeTopLeftPipe() {
        return putInTopLeftPosition(SPACE);
    }

    public Cell removeTopRightPipe() {
        return putInTopRightPosition(SPACE);
    }

    public Cell removeBottomLeftPipe() {
        return putInBottomLeftPosition(SPACE);
    }

    public Cell removeBottomRightPipe() {
        return putInBottomRightPosition(SPACE);
    }

    public Cell addTopUnderscore() {
        return putInTopPosition(UNDERSCORE);
    }

    public Cell addCenterUnderscore() {
        return putInCenterPosition(UNDERSCORE);
    }

    public Cell addBottomUnderscore() {
        return putInBottomPosition(UNDERSCORE);
    }

    public Cell removeTopUnderscore() {
        return putInTopPosition(SPACE);
    }

    public Cell removeCenterUnderscore() {
        return putInCenterPosition(SPACE);
    }

    public Cell removeBottomUnderscore() {
        return putInBottomPosition(SPACE);
    }

    public String asText() {
        switch (cellAsString) {
            case ZERO_CELL_AS_STRING:
                return "0";
            case ONE_CELL_AS_STRING:
                return "1";
            case TWO_CELL_AS_STRING:
                return "2";
            case THREE_CELL_AS_STRING:
                return "3";
            case FOUR_CELL_AS_STRING:
                return "4";
            case FIVE_CELL_AS_STRING:
                return "5";
            case SIX_CELL_AS_STRING:
                return "6";
            case SEVEN_CELL_AS_STRING:
                return "7";
            case EIGHT_CELL_AS_STRING:
                return "8";
            case NINE_CELL_AS_STRING:
                return "9";
        }
        return "?";
    }

    public boolean isValid() {
        return !"?".equals(asText());
    }

    private Cell putInTopLeftPosition(String s) {
        return new Cell(cellAsString.substring(0, 3) + s + cellAsString.substring(4));
    }

    private Cell putInTopRightPosition(String s) {
        return new Cell(cellAsString.substring(0, 5) + s + cellAsString.substring(6));
    }

    private Cell putInBottomLeftPosition(String s) {
        return new Cell(cellAsString.substring(0, 6) + s + cellAsString.substring(7));
    }

    private Cell putInBottomRightPosition(String s) {
        return new Cell(cellAsString.substring(0, 8) + s);
    }

    private Cell putInTopPosition(String s) {
        return new Cell(cellAsString.substring(0, 1) + s + cellAsString.substring(2));
    }

    private Cell putInCenterPosition(String s) {
        return new Cell(cellAsString.substring(0, 4) + s + cellAsString.substring(5));
    }

    private Cell putInBottomPosition(String s) {
        return new Cell(cellAsString.substring(0, 7) + s + cellAsString.substring(8));
    }

    @Override
    public String toString() {
        return "\n" + cellAsString.substring(0, 3) + "\n" + cellAsString.substring(3, 6) + "\n" + cellAsString.substring(6);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        return cellAsString.equals(cell.cellAsString);
    }

    @Override
    public int hashCode() {
        return cellAsString.hashCode();
    }
}
