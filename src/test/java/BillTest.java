import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tax.TaxService;
import tax.type.IncomeTaxType;
import tax.type.TaxType;
import static org.hamcrest.Matchers.*;

public class BillTest {
    Bill sut;
    TaxService taxService = new TaxService();

    @AfterEach
    public void after(){
        sut = null;
    }

    @Test
    public void BillWithValues(){
        double expectedAmount = 1_000;
        sut = new Bill(1_000, new TaxType(), taxService);
        Assertions.assertEquals(expectedAmount, sut.getAmount());
        assertTha
    }

    @Test
    public void BillWithTaxType(){
        double expected = 0;
        sut = new Bill(1000, new TaxType(), taxService);
        double result = sut.payTaxes();
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void BillWithIncomeTaxType(){
        double expected = 130;
        sut = new Bill(1000, new IncomeTaxType(), taxService);
        double result = sut.payTaxes();
        Assertions.assertEquals(expected, result);
    }
}
