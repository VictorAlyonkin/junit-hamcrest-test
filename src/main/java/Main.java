import tax.TaxService;
import tax.type.IncomeTaxType;
import tax.type.ProgressiveTaxType;
import tax.type.TaxType;
import tax.type.VATaxType;

public class Main {
    public static void main(String[] args) {
        TaxService taxService = new TaxService();
        Bill[] payments = new Bill[]{
                // создание платежей с различным типами налогообложения
                new Bill(200, new TaxType(), taxService),
                new Bill(200, new IncomeTaxType(), taxService),
                new Bill(400, new VATaxType(), taxService),
                new Bill(800, new ProgressiveTaxType(), taxService),
                new Bill(100_000, new ProgressiveTaxType(), taxService),
        };

        for (int i = 0; i < payments.length; ++i) {
            Bill bill = payments[i];
            bill.payTaxes();
        }
    }
}