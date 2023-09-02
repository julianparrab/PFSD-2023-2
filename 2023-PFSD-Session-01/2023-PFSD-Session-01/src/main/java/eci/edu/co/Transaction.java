package eci.edu.co;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Transaction {

    private Double value;
    private String currency;
    private String type;

    public static final String COP = "COP";
    public static final String USD = "USD";
    public static final String EUR = "EUR";

    public static List<String> currencies = new ArrayList<>(List.of(COP, USD, EUR));
    public static List<String> types = new ArrayList<>(List.of("Income", "Expense"));

    public Transaction(Double value, String currency, String type) {
        this.value = value;
        this.currency = currency;
        this.type = type;
    }

    public Double getValueInCop() {
        switch (currency) {
            case USD:
                return value * 4098;
            case EUR:
                return value * 4455;
            case COP:
                return value;
            default:
                return 0.0;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(value, that.value) && Objects.equals(currency, that.currency) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, currency, type);
    }

    @Override
    public String toString() {
        return "Value: " + value + ", Currency: " + currency + ", Type: " + type;
    }
}
