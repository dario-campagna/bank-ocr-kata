package test.banckocr;

import it.esteco.bankocr.BankOCR;
import it.esteco.bankocr.Entry;
import it.esteco.bankocr.EntryReader;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConvertMultipleEntriesTest {

    private BankOCR bankOCR = new BankOCR();
    private EntryReader reader = mock(EntryReader.class);


    @Test
    public void multipleEntriesToAccountNumbers() throws Exception {
        when(reader.readEntry())
                .thenReturn(allFoursEntry())
                .thenReturn(allSixEntry())
                .thenReturn(null);

        List accountNumbers = bankOCR.parse(reader);

        assertThat(accountNumbers, is(equalTo(Arrays.asList("444444444", "666666666"))));
    }

    private Entry allFoursEntry() {
        return new Entry(
                "                           ",
                "|_||_||_||_||_||_||_||_||_|",
                "  |  |  |  |  |  |  |  |  |");
    }

    private Entry allSixEntry() {
        return new Entry(
                " _  _  _  _  _  _  _  _  _ ",
                "|_ |_ |_ |_ |_ |_ |_ |_ |_ ",
                "|_||_||_||_||_||_||_||_||_|");
    }
}
