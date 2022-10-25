package tax.type;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ProgressiveTaxTypeTest {
    private ProgressiveTaxType sut;

    @BeforeEach
    public void beforeInit() {
        sut = new ProgressiveTaxType();
    }

    @AfterEach
    public void afterInit() {
        sut = null;
    }

    @Test
    public void calculateTaxForLess100_000() {
        double expected = 10;
        double rslt = sut.calculateTaxFor(100);
        assertThat(expected, is(equalTo(rslt)));
    }

    @Test
    public void calculateTaxForMore100_000() {
        double expected = 300_000;
        double rslt = sut.calculateTaxFor(2_000_000);
        assertThat(expected, is(equalTo(rslt)));
    }
}
