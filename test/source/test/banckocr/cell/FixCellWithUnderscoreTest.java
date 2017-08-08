package test.banckocr.cell;

import it.esteco.bankocr.domain.cell.Cell;
import it.esteco.bankocr.domain.cell.UnderscoreCellFixer;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FixCellWithUnderscoreTest {

    @Test
    public void addUnderscoreToFixWrongTwoCell() throws Exception {
        assertThat(new UnderscoreCellFixer().fix(new Cell(
                "   " +
                " _|" +
                "|_ ")), is(equalTo(Arrays.asList(new Cell(Cell.TWO_CELL_AS_STRING)))));
        assertThat(new UnderscoreCellFixer().fix(new Cell(
                " _ " +
                "  |" +
                "|_ ")), is(equalTo(Arrays.asList(new Cell(Cell.TWO_CELL_AS_STRING)))));
        assertThat(new UnderscoreCellFixer().fix(new Cell(
                " _ " +
                " _|" +
                "|  ")), is(equalTo(Arrays.asList(new Cell(Cell.TWO_CELL_AS_STRING)))));
    }

    @Test
    public void removeUnderscoreFromEightCell() throws Exception {
        assertThat(new UnderscoreCellFixer().fix(new Cell(Cell.EIGHT_CELL_AS_STRING)),
                is(equalTo(Arrays.asList(new Cell(Cell.ZERO_CELL_AS_STRING)))));
    }

    @Test
    public void fixCellByAddingAndRemovingUnderscore() throws Exception {
        assertThat(new UnderscoreCellFixer().fix(new Cell(
                " _ " +
                " _|" +
                "  |"
        )), is(equalTo(Arrays.asList(new Cell(Cell.THREE_CELL_AS_STRING), new Cell(Cell.SEVEN_CELL_AS_STRING)))));
    }
}
