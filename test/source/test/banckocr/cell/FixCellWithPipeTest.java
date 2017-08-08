package test.banckocr.cell;

import it.esteco.bankocr.domain.Cell;
import it.esteco.bankocr.domain.PipeCellFixer;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FixCellWithPipeTest {

    @Test
    public void addPipeToFixWrongOneCell() throws Exception {
        assertThat(new PipeCellFixer().fix(new Cell(
                        "   " +
                        "   " +
                        "  |")), is(equalTo(Arrays.asList(new Cell(Cell.ONE_CELL_AS_STRING)))));
        assertThat(new PipeCellFixer().fix(new Cell(
                        "   " +
                        "  |" +
                        "   ")), is(equalTo(Arrays.asList(new Cell(Cell.ONE_CELL_AS_STRING)))));
    }

    @Test
    public void addPipeToFiveCell() throws Exception {
        assertThat(new PipeCellFixer().fix(new Cell(Cell.FIVE_CELL_AS_STRING)),
                is(equalTo(Arrays.asList(new Cell(Cell.NINE_CELL_AS_STRING), new Cell(Cell.SIX_CELL_AS_STRING)))));
    }
}
