package test.banckocr;

import it.esteco.bankocr.domain.entry.Entry;
import it.esteco.bankocr.adapters.FileEntryReader;
import org.junit.Test;

import java.net.URL;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReadEntryFromFileTest {

    @Test
    public void readAllZerosEntry() throws Exception {
        URL allZerosSingleEntry = ReadEntryFromFileTest.class.getClassLoader().getResource("allZerosEntry");
        FileEntryReader reader = new FileEntryReader(allZerosSingleEntry.getFile());
        assertThat(reader.readEntry(), is(equalTo(new Entry(
                " _  _  _  _  _  _  _  _  _ ",
                "| || || || || || || || || |",
                "|_||_||_||_||_||_||_||_||_|"))));
    }
}
