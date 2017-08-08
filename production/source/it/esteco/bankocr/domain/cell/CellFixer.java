package it.esteco.bankocr.domain.cell;

import java.util.List;

public interface CellFixer {
    List<Cell> fix(Cell cell);
}
