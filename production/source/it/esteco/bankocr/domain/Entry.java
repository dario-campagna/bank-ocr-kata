package it.esteco.bankocr.domain;

public class Entry {

    private final String firstLine;
    private final String secondLine;
    private final String thirdLine;

    public Entry(String firstLine, String secondLine, String thirdLine) {
        this.firstLine = firstLine;
        this.secondLine = secondLine;
        this.thirdLine = thirdLine;
    }

    public String toAccountNumber() {
        return convert(firstLine, secondLine, thirdLine);
    }

    private String convert(String firstLine, String secondLine, String thirdLine) {
        if (firstLine.isEmpty()) {
            return "";
        } else {
            String cell = firstLine.substring(0, 3) + secondLine.substring(0, 3) + thirdLine.substring(0, 3);
            return CellConverter.toDigit(cell) + convert(firstLine.substring(3), secondLine.substring(3), thirdLine.substring(3));
        }
    }

    @Override
    public String toString() {
        return '\n' +
                firstLine + '\n' +
                secondLine + '\n' +
                thirdLine + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entry entry = (Entry) o;

        if (!firstLine.equals(entry.firstLine)) return false;
        if (!secondLine.equals(entry.secondLine)) return false;
        return thirdLine.equals(entry.thirdLine);
    }

    @Override
    public int hashCode() {
        int result = firstLine.hashCode();
        result = 31 * result + secondLine.hashCode();
        result = 31 * result + thirdLine.hashCode();
        return result;
    }
}
