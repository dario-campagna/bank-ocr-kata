package test.banckocr.cell;

import it.esteco.bankocr.domain.Cell;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RemoveUnderscoreToCellTest {

    @Test
    public void removeOneUnderscore() throws Exception {
        assertThat(new Cell(Cell.EIGHT_CELL_AS_STRING).removeTopUnderscore(), is(equalTo(new Cell(
                "   " +
                "|_|" +
                "|_|"))));
        assertThat(new Cell(Cell.EIGHT_CELL_AS_STRING).removeMiddleUnderscore(), is(equalTo(new Cell(
                " _ " +
                "| |" +
                "|_|"))));
        assertThat(new Cell(Cell.EIGHT_CELL_AS_STRING).removeBottomUnderscore(), is(equalTo(new Cell(
                " _ " +
                "|_|" +
                "| |"))));
    }
}