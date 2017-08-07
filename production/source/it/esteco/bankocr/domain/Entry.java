package it.esteco.bankocr.domain;

import java.util.ArrayList;
import java.util.List;

public class Entry {

    private final List<Cell> cells;

    public Entry(String firstLine, String secondLine, String thirdLine) {
        cells = toCells(firstLine, secondLine, thirdLine);
    }

    private List<Cell> toCells(String firstLine, String secondLine, String thirdLine) {
        List<Cell> cells = new ArrayList<>();
        if (firstLine.isEmpty()) {
            return cells;
        } else {
            cells.add(new Cell(firstLine.substring(0, 3) + secondLine.substring(0, 3) + thirdLine.substring(0, 3)));
            cells.addAll(toCells(firstLine.substring(3), secondLine.substring(3), thirdLine.substring(3)));
            return cells;
        }
    }

    public String asText() {
        String text = "";
        for (Cell cell : cells) {
            text += cell.asText();
        }
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entry entry = (Entry) o;

        return cells.equals(entry.cells);
    }

    @Override
    public int hashCode() {
        return cells.hashCode();
    }
}
