package test.banckocr;

import it.esteco.bankocr.Entry;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConvertEntryToAccountNumberTest {

    @Test
    public void convertAllZerosEntryToAccountNumber() throws Exception {
        Entry allZerosEntry = new Entry(
                " _  _  _  _  _  _  _  _  _ ",
                "| || || || || || || || || |",
                "|_||_||_||_||_||_||_||_||_|");
        assertThat(allZerosEntry.toAccountNumber(), is(equalTo("000000000")));
    }

    @Test
    public void convertAllOnesEntryToAccountNumber() throws Exception {
        Entry allZerosEntry = new Entry(
                "                           ",
                "  |  |  |  |  |  |  |  |  |",
                "  |  |  |  |  |  |  |  |  |");
        assertThat(allZerosEntry.toAccountNumber(), is(equalTo("111111111")));
    }

    @Test
    public void convertOneToNineEntryToAccountNumber() throws Exception {
        Entry allDigitEntry = new Entry(
                "    _  _     _  _  _  _  _ ",
                "  | _| _||_||_ |_   ||_||_|",
                "  ||_  _|  | _||_|  ||_| _|");
        assertThat(allDigitEntry.toAccountNumber(), is(equalTo("123456789")));
    }
}
