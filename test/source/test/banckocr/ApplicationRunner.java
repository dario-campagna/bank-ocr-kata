package test.banckocr;

import it.esteco.bankocr.Main;

import java.io.*;
import java.net.URL;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ApplicationRunner {

    private final ByteArrayOutputStream byteArrayOutputStream;
    private BufferedReader consoleReader;
    private PrintStream console;

    public ApplicationRunner() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        changeSystemOutTo(byteArrayOutputStream);
    }

    public void parseFile(URL allZerosSingleEntry) {
        Main.main(allZerosSingleEntry.getFile());
        consoleReader = createBufferReaderFor(byteArrayOutputStream);
    }

    public void showsAccountNumber(String accountNumberAsText) throws IOException {
        assertThat(consoleReader.readLine(), is(equalTo(accountNumberAsText)));
    }

    public void stop() {
        System.setOut(console);
    }

    private void changeSystemOutTo(ByteArrayOutputStream byteArrayOutputStream) {
        console = System.out;
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    private BufferedReader createBufferReaderFor(ByteArrayOutputStream byteArrayOutputStream) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        return new BufferedReader(new InputStreamReader(byteArrayInputStream));
    }
}
