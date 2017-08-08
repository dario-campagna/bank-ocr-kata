package test.banckocr.cell;

import it.esteco.bankocr.domain.Cell;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RemovePipeToCellTest {

    @Test
    public void addOnePipe() throws Exception {
        assertThat(new Cell(" _ " +
                            "  |" +
                            "|_|").addTopLeftPipe(), is(equalTo(new Cell(Cell.ZERO_CELL_AS_STRING))));
        assertThat(new Cell(" _ " +
                            "|  " +
                            "|_|").addTopRightPipe(), is(equalTo(new Cell(Cell.ZERO_CELL_AS_STRING))));
        assertThat(new Cell(" _ " +
                            "| |" +
                            " _|").addBottomLeftPipe(), is(equalTo(new Cell(Cell.ZERO_CELL_AS_STRING))));
        assertThat(new Cell(" _ " +
                            "| |" +
                            "|_ ").addBottomRightPipe(), is(equalTo(new Cell(Cell.ZERO_CELL_AS_STRING))));
    }

    @Test
    public void removeOnePipe() throws Exception {
        assertThat(new Cell(Cell.ZERO_CELL_AS_STRING).removeTopLeftPipe(), is(equalTo(new Cell(
                " _ " +
                "  |" +
                "|_|"))));
        assertThat(new Cell(Cell.ZERO_CELL_AS_STRING).removeTopRightPipe(), is(equalTo(new Cell(
                        " _ " +
                        "|  " +
                        "|_|"))));
        assertThat(new Cell(Cell.ZERO_CELL_AS_STRING).removeBottomLeftPipe(), is(equalTo(new Cell(
                        " _ " +
                        "| |" +
                        " _|"))));
        assertThat(new Cell(Cell.ZERO_CELL_AS_STRING).removeBottomRightPipe(), is(equalTo(new Cell(
                        " _ " +
                        "| |" +
                        "|_ "))));
    }
}
