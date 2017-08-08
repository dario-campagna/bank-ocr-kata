package test.banckocr.entry;

import it.esteco.bankocr.domain.Entry;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConvertEntryToTextTest {

    @Test
    public void convertAllZerosEntryToText() throws Exception {
        Entry allZerosEntry = new Entry(
                " _  _  _  _  _  _  _  _  _ ",
                "| || || || || || || || || |",
                "|_||_||_||_||_||_||_||_||_|");
        assertThat(allZerosEntry.asText(), is(equalTo("000000000")));
    }

    @Test
    public void convertAllOnesEntryToAccountNumber() throws Exception {
        Entry allZerosEntry = new Entry(
                "                           ",
                "  |  |  |  |  |  |  |  |  |",
                "  |  |  |  |  |  |  |  |  |");
        assertThat(allZerosEntry.asText(), is(equalTo("111111111")));
    }

    @Test
    public void convertOneToNineEntryToAccountNumber() throws Exception {
        Entry allDigitEntry = new Entry(
                "    _  _     _  _  _  _  _ ",
                "  | _| _||_||_ |_   ||_||_|",
                "  ||_  _|  | _||_|  ||_| _|");
        assertThat(allDigitEntry.asText(), is(equalTo("123456789")));
    }

    @Test
    public void convertIllegibleEntryToAccountNumber() throws Exception {
        Entry allDigitEntry = new Entry(
                "    _  _     _  _  _  _  _ ",
                "  | _  _||_||_ |_   | _ |_|",
                "  ||_  _|  | _ |_|  | _| _|");
        assertThat(allDigitEntry.asText(), is(equalTo("1?34?67?9")));
    }
}
