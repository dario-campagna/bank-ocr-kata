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

    private final String cellAsString;

    public Cell(String cellAsString) {
        this.cellAsString = cellAsString;
    }

    public Cell addTopLeftPipe() {
        return new Cell(cellAsString.substring(0, 3) + "|" + cellAsString.substring(4));
    }

    public Cell addTopRightPipe() {
        return new Cell(cellAsString.substring(0, 5) + "|" + cellAsString.substring(6));
    }

    public Cell addBottomLeftPipe() {
        return new Cell(cellAsString.substring(0, 6) + "|" + cellAsString.substring(7));
    }

    public Cell addBottomRightPipe() {
        return new Cell(cellAsString.substring(0, 8) + "|");
    }

    public Cell addTopUnderscore() {
        return new Cell(cellAsString.substring(0,1) + "_" + cellAsString.substring(2));
    }

    public Cell addMiddleUnderscore() {
        return new Cell(cellAsString.substring(0,4) + "_" + cellAsString.substring(5));
    }

    public Cell addBottomUnderscore() {
        return new Cell(cellAsString.substring(0,7) + "_" + cellAsString.substring(8));
    }

    public Cell removeTopUnderscore() {
        return new Cell(cellAsString.substring(0,1) + " " + cellAsString.substring(2));
    }

    public Cell removeMiddleUnderscore() {
        return new Cell(cellAsString.substring(0,4) + " " + cellAsString.substring(5));
    }

    public Cell removeBottomUnderscore() {
        return new Cell(cellAsString.substring(0,7) + " " + cellAsString.substring(8));
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

    @Override
    public String toString() {
        return "\n" + cellAsString.substring(0,3) + "\n" + cellAsString.substring(3,6) + "\n" + cellAsString.substring(6);
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
