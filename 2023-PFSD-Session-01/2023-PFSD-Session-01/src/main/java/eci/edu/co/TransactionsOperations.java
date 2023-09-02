package eci.edu.co;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TransactionsOperations {

    public static List<Transaction> join(List<Transaction> transactionList1, List<Transaction> transactionList2) {
        ArrayList<Transaction> result = new ArrayList<>(transactionList1);
        result.addAll(transactionList2);
        return result;
    }

    // TODO
    public static List<Transaction> add(Transaction t, List<Transaction> transactionList) {
        ArrayList<Transaction> transactionAdded = new ArrayList<>(transactionList);
        transactionAdded.add(t);
        return transactionAdded;
    }

    // TODO
    public static List<Transaction> distinct(List<Transaction> transactionList) {
        ArrayList<Transaction> transactionDistinct = new ArrayList<>();

        transactionDistinct.add(transactionList.get(0));

        for (int i = 0; i < transactionList.size(); i++) {
            for (int j = 0; j < 1; j++) {
                if (!Objects.equals(transactionDistinct.get(j).getValueInCop(), transactionList.get(i).getValueInCop()))
                    transactionDistinct.add(0,transactionList.get(i));
            }
        }

        return transactionDistinct;
    }

    // TODO
    public static Transaction head(List<Transaction> transactionList) {
        return transactionList.get(0);
    }

    // TODO
    public static List<Transaction> tail(List<Transaction> transactionList) {
        ArrayList<Transaction> result = new ArrayList<>();

        for (int i = 1; i < transactionList.size(); i++){
            result.add(transactionList.get(i));
        }
        return result;
    }

    // TODO
    public static Transaction max(List<Transaction> transactionList) {
        Double maxValue = 0.0;
        int indexMax = 0;
        for (int i = 0; i < transactionList.size(); i++)
        {
            if (transactionList.get(i).getValueInCop() >= maxValue) {
                maxValue = transactionList.get(i).getValueInCop();
                indexMax = i;
            }
        }
        return transactionList.get(indexMax);
    }

    // TODO
    public static Transaction min(List<Transaction> transactionList) {
        Double minValue = transactionList.get(0).getValueInCop();
        int indexMin = 0;

        for (int i = 0; i < transactionList.size(); i++)
        {
            if (transactionList.get(i).getValueInCop() <= minValue) {
                minValue = transactionList.get(i).getValueInCop();
                indexMin = i;
            }
        }
        return transactionList.get(indexMin);
    }
}
