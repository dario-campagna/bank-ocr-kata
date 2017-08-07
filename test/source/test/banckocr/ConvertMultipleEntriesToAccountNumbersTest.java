package test.banckocr;

import it.esteco.bankocr.domain.AccountNumber;
import it.esteco.bankocr.domain.BankOCR;
import it.esteco.bankocr.domain.Entry;
import it.esteco.bankocr.domain.EntryReader;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConvertMultipleEntriesToAccountNumbersTest {

    private BankOCR bankOCR = new BankOCR();
    private EntryReader reader = mock(EntryReader.class);


    @Test
    public void multipleEntriesToAccountNumbers() throws Exception {
        when(reader.readEntry())
                .thenReturn(allFoursEntry())
                .thenReturn(allSixEntry())
                .thenReturn(illegibleEntry())
                .thenReturn(null);

        List<AccountNumber> accountNumbers = bankOCR.parse(reader);

        assertThat(accountNumbers, is(equalTo(Arrays.asList(
                new AccountNumber("444444444"),
                new AccountNumber("666666666"),
                new AccountNumber("44?44?444")))));
    }

    private Entry illegibleEntry() {
        return new Entry(
                "                           ",
                "|_||_|| ||_||_||_||_||_||_|",
                "  |  |  |  |  |     |  |  |");
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
