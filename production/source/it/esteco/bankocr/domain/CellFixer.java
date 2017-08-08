package it.esteco.bankocr.domain;

import java.util.List;

public interface CellFixer {
    List<Cell> fix(Cell cell);
}
