package it.esteco.bankocr.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UnderscoreCellFixer {
    public List<Cell> fix(Cell cell) {
        List<Cell> cells = new ArrayList<>();
        cells.add(cell.addTopUnderscore());
        cells.add(cell.addMiddleUnderscore());
        cells.add(cell.addBottomUnderscore());
        cells.add(cell.removeTopUnderscore());
        cells.add(cell.removeMiddleUnderscore());
        cells.add(cell.removeBottomUnderscore());
        return cells.stream().filter(c -> c.isValid() && !c.equals(cell)).collect(Collectors.toList());
    }
}
