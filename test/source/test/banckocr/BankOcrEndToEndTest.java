package test.banckocr;

import it.esteco.bankocr.BankOCR;
import org.junit.Test;

import java.io.InputStream;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class BankOcrEndToEndTest {

    @Test
    public void parseFileWithSingleAllZerosEntryIntoActualAccountNumber() throws Exception {
        BankOCR ocr = new BankOCR();

        InputStream allZerosSingleEntry = BankOcrEndToEndTest.class.getClassLoader().getResourceAsStream("allZerosSingleEntry");
        assertThat(ocr.parse(allZerosSingleEntry), is(equalTo(Arrays.asList("000000000"))));
    }

}
