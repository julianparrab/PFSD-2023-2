package eci.edu.co;

import java.util.Random;

public class TransactionFactory {

    private static Random random = new Random();

    public static Transaction generateTransaction() {
        var currency = generateCurrency();
        var value = generateValue(currency);
        var type = generateType();
        return new Transaction(value, currency, type);
    }

    public static String generateCurrency() {
        return Transaction.currencies.get(random.nextInt(Transaction.currencies.size()));
    }

    public static String generateType() {
        return Transaction.types.get(random.nextInt(Transaction.types.size()));
    }

    public static Double generateValue(String currency) {
        switch (currency) {
            case Transaction.USD:
                return (double) random.nextInt(15);
            case Transaction.EUR:
                return (double) random.nextInt(10);
            case Transaction.COP:
                return (double) random.nextInt(50000);
            default:
                return 0.0;
        }
    }
}
