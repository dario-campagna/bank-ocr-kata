package test.banckocr;

import org.junit.Test;

import java.net.URL;

public class BankOcrEndToEndTest {

    @Test
    public void parseFileWithSingleAllZerosEntryIntoActualAccountNumber() throws Exception {
        URL allZerosSingleEntry = BankOcrEndToEndTest.class.getClassLoader().getResource("allZerosEntry");
        ApplicationRunner application = new ApplicationRunner();

        application.parseFile(allZerosSingleEntry);
        application.showsAccountNumber("000000000");
        application.stop();
    }

    @Test
    public void parseFileWithSingleAllOnesEntryIntoActualAccountNumber() throws Exception {
        URL allOnesSingleEntry = BankOcrEndToEndTest.class.getClassLoader().getResource("allOnesEntry");
        ApplicationRunner application = new ApplicationRunner();

        application.parseFile(allOnesSingleEntry);
        application.showsAccountNumber("111111111 ERR");
        application.stop();
    }

    @Test
    public void parseFileWithMultipleAllZerosEntryIntoActualAccountNumbers() throws Exception {
        URL allOnesSingleEntry = BankOcrEndToEndTest.class.getClassLoader().getResource("multipleEntries");
        ApplicationRunner application = new ApplicationRunner();

        application.parseFile(allOnesSingleEntry);
        application.showsAccountNumber("457508000");
        application.showsAccountNumber("664371495 ERR");
        application.showsAccountNumber("86110??36 ILL");
        application.stop();
    }

}
