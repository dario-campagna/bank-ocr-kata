package it.esteco.bankocr.domain;

import java.util.ArrayList;
import java.util.List;

public class Entry {

    private final List<Cell> cells;

    public Entry(String firstLine, String secondLine, String thirdLine) {
        cells = toCells(firstLine, secondLine, thirdLine);
    }

    private Entry(List<Cell> cells) {
        this.cells = cells;
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

    public List<Entry> fixWith(CellFixer cellFixer) {
        List<Entry> newEntries = new ArrayList<>();
        for (int i = 0; i < cells.size(); i++) {
            for (Cell fixedCell : cellFixer.fix(cells.get(i))) {
                List<Cell> newCells = new ArrayList<>(cells);
                newCells.set(i, fixedCell);
                newEntries.add(new Entry(newCells));
            }
        }
        return newEntries;
    }

    @Override
    public String toString() {
        return cells.toString();
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
