package test.banckocr.cell;

import it.esteco.bankocr.domain.Cell;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AddUnderscoreToCellTest {

    @Test
    public void addOneUnderscore() throws Exception {
        assertThat(new Cell(
                "   " +
                "|_|" +
                "|_|").addTopUnderscore(), is(equalTo(new Cell(Cell.EIGHT_CELL_AS_STRING))));
        assertThat(new Cell(
                " _ " +
                "| |" +
                "|_|").addMiddleUnderscore(), is(equalTo(new Cell(Cell.EIGHT_CELL_AS_STRING))));
        assertThat(new Cell(
                " _ " +
                "|_|" +
                "| |").addBottomUnderscore(), is(equalTo(new Cell(Cell.EIGHT_CELL_AS_STRING))));
    }
}