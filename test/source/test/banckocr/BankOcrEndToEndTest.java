package test.banckocr;

import org.junit.Test;

import java.net.URL;

public class BankOcrEndToEndTest {

    @Test
    public void parseFileWithSingleAllZerosEntryIntoActualAccountNumber() throws Exception {
        URL allZerosSingleEntry = BankOcrEndToEndTest.class.getClassLoader().getResource("allZerosSingleEntry");
        ApplicationRunner application = new ApplicationRunner();

        application.parseFile(allZerosSingleEntry);
        application.showsAccountNumber("000000000");
    }

    @Test
    public void parseFileWithSingleAllOnesEntryIntoActualAccountNumber() throws Exception {
        URL allOnesSingleEntry = BankOcrEndToEndTest.class.getClassLoader().getResource("allOnesSingleEntry");
        ApplicationRunner application = new ApplicationRunner();

        application.parseFile(allOnesSingleEntry);
        application.showsAccountNumber("111111111");
    }

}
