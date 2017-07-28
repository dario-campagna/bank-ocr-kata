package test.banckocr;

import it.esteco.bankocr.Main;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ApplicationRunner {

    private static final String OUTPUT_FILE = "out";
    private BufferedReader outputReader;


    public void parseFile(URL fileURL) throws FileNotFoundException {
        Main.main(fileURL.getFile(), OUTPUT_FILE);
        FileReader fileReader = new FileReader(OUTPUT_FILE);
        outputReader = new BufferedReader(fileReader);
    }

    public void showsAccountNumber(String accountNumberAsText) throws IOException {
        assertThat(outputReader.readLine(), is(equalTo(accountNumberAsText)));
    }

    public void stop() throws IOException {
        outputReader.close();
        Files.deleteIfExists(new File(OUTPUT_FILE).toPath());
    }

}
