package test.banckocr.accountnumber;

import it.esteco.bankocr.domain.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ConvertMultipleEntriesToAccountNumbersTest {

    private BankOCR bankOCR = new BankOCR(new AccountNumberFixer(Arrays.asList(new PipeCellFixer(), new UnderscoreCellFixer())));
    private EntryReader reader = mock(EntryReader.class);


    @Test
    public void multipleEntriesToAccountNumbers() throws Exception {
        when(reader.readEntry())
                .thenReturn(validEntry())
                .thenReturn(ambiguousEntry())
                .thenReturn(illegibleEntry())
                .thenReturn(null);

        List<AccountNumber> accountNumbers = bankOCR.parse(reader);

        assertThat(accountNumbers, is(equalTo(Arrays.asList(
                new AccountNumber("200800000"),
                new AccountNumber("666666666", Arrays.asList(new AccountNumber("686666666"), new AccountNumber("666566666"))),
                new AccountNumber("000000051")))));
    }

    private Entry validEntry() {
        return new Entry(
                " _  _  _  _  _  _  _  _  _ ",
                " _|| || ||_|| || || || || |",
                "|_ |_||_||_||_||_||_||_||_|");
    }

    private Entry ambiguousEntry() {
        return new Entry(
                " _  _  _  _  _  _  _  _  _ ",
                "|_ |_ |_ |_ |_ |_ |_ |_ |_ ",
                "|_||_||_||_||_||_||_||_||_|");
        
    }   
        
    private Entry illegibleEntry() {
        return new Entry(
                " _     _  _  _  _  _  _    ",
                "| || || || || || || ||_   |",
                "|_||_||_||_||_||_||_| _|  |");
    }
}
