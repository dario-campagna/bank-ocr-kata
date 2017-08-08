package test.banckocr.accountnumber;

import it.esteco.bankocr.domain.accountnumber.AccountNumber;
import it.esteco.bankocr.domain.accountnumber.AccountNumberFormatter;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FormatAccountNumberTest {

    private final AccountNumberFormatter formatter = new AccountNumberFormatter();

    @Test
    public void formatValidAccountNumber() throws Exception {
        AccountNumber validAccountNumber = new AccountNumber("000000000");
        assertThat(formatter.format(validAccountNumber), is(equalTo("000000000")));
    }

    @Test
    public void formatInvalidAccountNumber() throws Exception {
        AccountNumber invalidAccountNumber = new AccountNumber("000000001");
        assertThat(formatter.format(invalidAccountNumber), is(equalTo("000000001 ERR")));
    }

    @Test
    public void formatIllegibleAccountNumber() throws Exception {
        AccountNumber illegibleAccountNumber = new AccountNumber("123?123?9");
        assertThat(formatter.format(illegibleAccountNumber), is(equalTo("123?123?9 ILL")));
    }

    @Test
    public void formatAmbigousAccountNumber() throws Exception {
        AccountNumber ambiguousAccountNumber = new AccountNumber("555555555", Arrays.asList(new AccountNumber("559555555"), new AccountNumber("555655555")));
        assertThat(formatter.format(ambiguousAccountNumber), is(equalTo("555555555 AMB ['559555555', '555655555']")));
    }
}
