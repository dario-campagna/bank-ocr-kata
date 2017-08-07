package test.banckocr;

import it.esteco.bankocr.domain.Cell;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CellToTextTest {

    @Test
    public void cellToDigit() throws Exception {
        assertThat(new Cell(" _ "+
                            "| |" +
                            "|_|").asText(), is(equalTo("0")));
        assertThat(new Cell("   "+
                            "  |" +
                            "  |").asText(), is(equalTo("1")));
        assertThat(new Cell(" _ "+
                            " _|" +
                            "|_ ").asText(), is(equalTo("2")));
        assertThat(new Cell(" _ "+
                            " _|" +
                            " _|").asText(), is(equalTo("3")));
        assertThat(new Cell("   "+
                            "|_|" +
                            "  |").asText(), is(equalTo("4")));
        assertThat(new Cell(" _ "+
                            "|_ " +
                            " _|").asText(), is(equalTo("5")));
        assertThat(new Cell(" _ "+
                            "|_ " +
                            "|_|").asText(), is(equalTo("6")));
        assertThat(new Cell(" _ "+
                            "  |" +
                            "  |").asText(), is(equalTo("7")));
        assertThat(new Cell(" _ "+
                            "|_|" +
                            "|_|").asText(), is(equalTo("8")));
        assertThat(new Cell(" _ "+
                            "|_|" +
                            " _|").asText(), is(equalTo("9")));
    }

    @Test
    public void cellToQuestionMark() throws Exception {
        assertThat(new Cell(" _ "+
                            "|  " +
                            " _|").asText(), is(equalTo("?")));
        assertThat(new Cell("   "+
                            "  |" +
                            " _|").asText(), is(equalTo("?")));
        assertThat(new Cell(" _ "+
                            " _ " +
                            " _ ").asText(), is(equalTo("?")));
    }
}
