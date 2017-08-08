package test.banckocr;

import it.esteco.bankocr.domain.Cell;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AddPipeToCellTest {

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
}
