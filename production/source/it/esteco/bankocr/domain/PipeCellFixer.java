package it.esteco.bankocr.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PipeCellFixer implements CellFixer {

    @Override
    public List<Cell> fix(Cell cell) {
        List<Cell> cells = new ArrayList<>();
        cells.add(cell.addTopLeftPipe());
        cells.add(cell.addTopRightPipe());
        cells.add(cell.addBottomLeftPipe());
        cells.add(cell.addBottomRightPipe());
        cells.add(cell.removeTopLeftPipe());
        cells.add(cell.removeTopRightPipe());
        cells.add(cell.removeBottomLeftPipe());
        cells.add(cell.removeBottomRightPipe());
        return cells.stream().filter(c -> c.isValid() && !c.equals(cell)).collect(Collectors.toList());
    }
}
