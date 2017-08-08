package test.banckocr.accountnumber;

import it.esteco.bankocr.domain.AccountNumber;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CheckAccountNumberTest {

    @Test
    public void invalidAccountNumber() throws Exception {
        AccountNumber accountNumber = new AccountNumber("000000001");
        assertThat(accountNumber.isValid(), is(false));
        AccountNumber anotherAccountNumber = new AccountNumber("664371495");
        assertThat(anotherAccountNumber.isValid(), is(false));
    }

    @Test
    public void validAccountNumber() throws Exception {
        AccountNumber accountNumber = new AccountNumber("000000000");
        assertThat(accountNumber.isValid(), is(true));
    }

}