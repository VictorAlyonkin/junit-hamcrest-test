package tax.type;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.hamcrest.MatcherAssert;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgressiveTaxTypeTest {
    ProgressiveTaxType sut;

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
        double asd = sut.calculateTaxFor(100);
        assertEquals(expected, asd);
    }
    @Test
    public void calculateTaxForMore100_000() {
        double expected = 300_000;
        double asd = sut.calculateTaxFor(2_000_000);
        assertEquals(expected, asd);
    }
}
