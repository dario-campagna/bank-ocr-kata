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
        application.showsAccountNumber("711111111");
        application.stop();
    }

    @Test
    public void parseFileWithMultipleAllZerosEntryIntoActualAccountNumbers() throws Exception {
        URL allOnesSingleEntry = BankOcrEndToEndTest.class.getClassLoader().getResource("multipleEntries");
        ApplicationRunner application = new ApplicationRunner();

        application.parseFile(allOnesSingleEntry);
        application.showsAccountNumber("200800000");
        application.showsAccountNumber("999999999 AMB ['899999999', '993999999', '999959999']");
        application.showsAccountNumber("490867715");
        application.stop();
    }

}
