package it.esteco.bankocr;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    private BankOCR bankOCR;

    public Main() {
        bankOCR = new BankOCR();
    }

    public static void main(String... args) {
        Main main = new Main();
        main.parse(args[0]);
    }

    private void parse(String fileURLAsText) {
        try {
            String accountNumber = bankOCR.parse(new URL(fileURLAsText));
            System.out.println(accountNumber);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
