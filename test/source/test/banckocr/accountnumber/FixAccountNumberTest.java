package test.banckocr.accountnumber;

import it.esteco.bankocr.domain.accountnumber.AccountNumber;
import it.esteco.bankocr.domain.accountnumber.AccountNumberFixer;
import it.esteco.bankocr.domain.cell.CellFixer;
import it.esteco.bankocr.domain.cell.PipeCellFixer;
import it.esteco.bankocr.domain.cell.UnderscoreCellFixer;
import it.esteco.bankocr.domain.entry.Entry;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FixAccountNumberTest {

    private List<CellFixer> fixers = Arrays.asList(new PipeCellFixer(), new UnderscoreCellFixer());

    @Test
    public void fixInvalidAccountNumber() throws Exception {
        assertThat(new AccountNumberFixer(fixers).fix(new Entry(
                "                           ",
                "  |  |  |  |  |  |  |  |  |",
                "  |  |  |  |  |  |  |  |  |")), is(equalTo(new AccountNumber("711111111"))));
        assertThat(new AccountNumberFixer(fixers).fix(new Entry(
                " _  _  _  _  _  _  _  _  _ ",
                "  |  |  |  |  |  |  |  |  |",
                "  |  |  |  |  |  |  |  |  |")), is(equalTo(new AccountNumber("777777177"))));
        assertThat(new AccountNumberFixer(fixers).fix(new Entry(
                " _  _  _  _  _  _  _  _  _ ",
                " _|| || || || || || || || |",
                "|_ |_||_||_||_||_||_||_||_|")), is(equalTo(new AccountNumber("200800000"))));
        assertThat(new AccountNumberFixer(fixers).fix(new Entry(
                " _  _  _  _  _  _  _  _  _ ",
                " _| _| _| _| _| _| _| _| _|",
                " _| _| _| _| _| _| _| _| _|")), is(equalTo(new AccountNumber("333393333"))));
    }

    @Test
    public void fixInvalidAmbiguousAccountNumber() throws Exception {
        assertThat(new AccountNumberFixer(fixers).fix(new Entry(
                " _  _  _  _  _  _  _  _  _ ",
                "|_||_||_||_||_||_||_||_||_|",
                "|_||_||_||_||_||_||_||_||_|"
        )), is(equalTo(new AccountNumber("888888888", Arrays.asList(new AccountNumber("888886888"), new AccountNumber("888888988"), new AccountNumber("888888880"))))));
        assertThat(new AccountNumberFixer(fixers).fix(new Entry(
                " _  _  _  _  _  _  _  _  _ ",
                "|_ |_ |_ |_ |_ |_ |_ |_ |_ ",
                " _| _| _| _| _| _| _| _| _|"
        )), is(equalTo(new AccountNumber("555555555", Arrays.asList(new AccountNumber("559555555"), new AccountNumber("555655555"))))));
        assertThat(new AccountNumberFixer(fixers).fix(new Entry(
                " _  _  _  _  _  _  _  _  _ ",
                "|_ |_ |_ |_ |_ |_ |_ |_ |_ ",
                "|_||_||_||_||_||_||_||_||_|"
        )), is(equalTo(new AccountNumber("666666666", Arrays.asList(new AccountNumber("686666666"), new AccountNumber("666566666"))))));
    }

    @Test
    public void fixIllegibleAccountNumber() throws Exception {
        assertThat(new AccountNumberFixer(fixers).fix(new Entry(
                "    _  _     _  _  _  _  _ ",
                " _| _| _||_||_ |_   ||_||_|",
                "  ||_  _|  | _||_|  ||_| _|")), is(equalTo(new AccountNumber("123456789"))));
    }

    @Test
    public void notFixableIllegibleAccountNumber() throws Exception {
        assertThat(new AccountNumberFixer(fixers).fix(new Entry(
                "    _  _     _  _  _  _  _ ",
                "  | _| _||_| _ |_   ||_||_|",
                "  ||_  _|  | _||_|  ||_| _ ")), is(equalTo(new AccountNumber("1234?678?"))));
    }
}