package test.banckocr;

import it.esteco.bankocr.domain.AccountNumber;
import org.junit.Test;

import java.lang.management.MemoryManagerMXBean;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CheckAccountNumberTest {

    @Test
    public void invalidAccountNumber() throws Exception {
        AccountNumber accountNumber = new AccountNumber(Arrays.asList(0,0,0,0,0,0,0,0,1));
        assertThat(accountNumber.isValid(), is(false));
        AccountNumber anotherAccountNumber = new AccountNumber(Arrays.asList(6,6,4,3,7,1,4,9,5));
        assertThat(accountNumber.isValid(), is(false));
    }

    @Test
    public void validAccountNumber() throws Exception {
        AccountNumber accountNumber = new AccountNumber(Arrays.asList(0,0,0,0,0,0,0,0,0));
        assertThat(accountNumber.isValid(), is(true));
    }

}
