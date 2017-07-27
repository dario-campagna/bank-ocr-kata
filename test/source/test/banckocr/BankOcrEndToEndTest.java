package test.banckocr;

import it.esteco.bankocr.BankOCR;
import org.junit.Ignore;
import org.junit.Test;

import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class BankOcrEndToEndTest {

    @Test
    public void parseFileWithSingleAllZerosEntryIntoActualAccountNumber() throws Exception {
        BankOCR ocr = new BankOCR();

        URL allZerosSingleEntry = BankOcrEndToEndTest.class.getClassLoader().getResource("allZerosSingleEntry");
        assertThat(ocr.parse(allZerosSingleEntry), is(equalTo(Arrays.asList("000000000"))));
    }

    @Test
    public void parseFileWithSingleAllOnesEntryIntoActualAccountNumber() throws Exception {
        BankOCR ocr = new BankOCR();

        URL allOnesSingleEntry = BankOcrEndToEndTest.class.getClassLoader().getResource("allOnesSingleEntry");
        assertThat(ocr.parse(allOnesSingleEntry), is(equalTo(Arrays.asList("111111111"))));
    }

}
