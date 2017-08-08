package test.banckocr.entry;

import it.esteco.bankocr.domain.Entry;
import it.esteco.bankocr.domain.PipeCellFixer;
import it.esteco.bankocr.domain.UnderscoreCellFixer;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FixEntryTest {

    @Test
    public void fixEntryWithOnePipe() throws Exception {
        assertThat(new Entry(
                "                           ",
                "     |  |  |  |  |  |  |  |",
                "  |  |  |  |  |  |  |  |  |").fixWith(new PipeCellFixer()), is(equalTo(Arrays.asList(new Entry(
                "                           ",
                "  |  |  |  |  |  |  |  |  |",
                "  |  |  |  |  |  |  |  |  |")))));
    }

    @Test
    public void addingRemovingOnePipeLeadsToMultipleEntries() throws Exception {
        assertThat(new Entry(
                " _                       _ ",
                "|_|  |  |  |  |  |  |  ||_|",
                " _|  |  |  |  |  |  |  | _|").fixWith(new PipeCellFixer()), is(equalTo(Arrays.asList(
                new Entry(
                        " _                       _ ",
                        "|_|  |  |  |  |  |  |  ||_|",
                        "|_|  |  |  |  |  |  |  | _|"),
                new Entry(
                        " _                       _ ",
                        " _|  |  |  |  |  |  |  ||_|",
                        " _|  |  |  |  |  |  |  | _|"),
                new Entry(
                        " _                       _ ",
                        "|_   |  |  |  |  |  |  ||_|",
                        " _|  |  |  |  |  |  |  | _|"),
                new Entry(
                        " _                       _ ",
                        "|_|  |  |  |  |  |  |  ||_|",
                        " _|  |  |  |  |  |  |  ||_|"),
                new Entry(
                        " _                       _ ",
                        "|_|  |  |  |  |  |  |  | _|",
                        " _|  |  |  |  |  |  |  | _|"),
                new Entry(
                        " _                       _ ",
                        "|_|  |  |  |  |  |  |  ||_ ",
                        " _|  |  |  |  |  |  |  | _|")))));
    }

    @Test
    public void fixEntryWithOneUnderscore() throws Exception {
        assertThat(new Entry(
                " _     _  _  _  _  _  _  _ ",
                " _| _| _| _| _| _| _| _| _|",
                " _| _| _| _| _| _| _| _| _|").fixWith(new UnderscoreCellFixer()), is(equalTo(Arrays.asList(new Entry(
                " _  _  _  _  _  _  _  _  _ ",
                " _| _| _| _| _| _| _| _| _|",
                " _| _| _| _| _| _| _| _| _|")))));
    }

    @Test
    public void addingRemovingOneUnderscoreLeadsToMultipleEntries() throws Exception {
        assertThat(new Entry(
                " _  _  _  _  _  _  _  _  _ ",
                " _| _| _| _| _| _| _| _| _|",
                "  | _| _| _| _| _| _| _| _|"
        ).fixWith(new UnderscoreCellFixer()), is(equalTo(Arrays.asList(
                new Entry(
                        " _  _  _  _  _  _  _  _  _ ",
                        " _| _| _| _| _| _| _| _| _|",
                        " _| _| _| _| _| _| _| _| _|"
                ),
                new Entry(
                        " _  _  _  _  _  _  _  _  _ ",
                        "  | _| _| _| _| _| _| _| _|",
                        "  | _| _| _| _| _| _| _| _|"
                )
        ))));
    }
}
