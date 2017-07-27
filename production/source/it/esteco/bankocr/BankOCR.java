package it.esteco.bankocr;

public class BankOCR {
    public String parse(EntryReader reader) {
        try {
            Entry entry = reader.readEntry();
            return entry.toAccountNumber();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
