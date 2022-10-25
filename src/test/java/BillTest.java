import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import tax.TaxService;
import tax.type.TaxType;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BillTest {
    private Bill sut;
    private TaxService taxService = new TaxService();

    @AfterEach
    public void after() {
        sut = null;
    }

    @Test
    public void billWithValues() {
        double expectedAmount = 1_000;
        sut = new Bill(1_000, new TaxType(), taxService);
        assertThat(expectedAmount, equalTo(sut.getAmount()));
    }

    @Test
    public void billWithTaxType() {
        double expected = 0;
        sut = new Bill(1000, new TaxType(), taxService);
        double result = sut.payTaxes();
        assertThat(expected, is(equalTo(result)));
    }

    @Test
    public void givenString_whenConditions_thenCorrect() {
        String string = "Kvadro";
        assertThat(string, anyOf(containsString("vad"), endsWith("dro")));
    }

    @Test
    public void givenNumber_whenConditions_thenCorrect() {
        Integer intVal = 1001;
        assertThat(intVal,
                allOf(greaterThan(999),
                        lessThanOrEqualTo(10_000),
                        not(equalTo(1_000))
                )
        );
    }
}
