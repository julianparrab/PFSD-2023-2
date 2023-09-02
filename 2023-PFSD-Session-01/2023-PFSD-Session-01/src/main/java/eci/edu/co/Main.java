package eci.edu.co;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Transaction> transactionList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            transactionList.add(TransactionFactory.generateTransaction());
        }

        System.out.println("\n\nAll Transactions\n");
        for (Transaction transaction : transactionList) {
            System.out.println(transaction);
        }

        List<Transaction> copTransactions = getCopTransactionsBiggerThan20000(transactionList);

        System.out.println("\n\nTransactions bigger than $20.000 COP\n");
        for (Transaction transaction : copTransactions) {
            System.out.println(transaction);
        }
    }

    private static List<Transaction> getCopTransactionsBiggerThan20000(List<Transaction> transactionList) {
        List<Transaction> cop20000Transactions = new ArrayList<>();
        for (Transaction transaction : transactionList) {
            if (transaction.getValueInCop() > 20000) {
                cop20000Transactions.add(transaction);
            }
        }
        return cop20000Transactions;
    }

}
