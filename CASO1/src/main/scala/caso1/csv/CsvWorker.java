package caso1.csv;

import caso1.entities.Transaction;

import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CsvWorker {

    /**
     * Read cvsFile
     *
     * @param path File route
     * @return Transaction's list from cvs file
     * @throws IOException
     */
    public static List<Transaction> readFile(String path) throws IOException {
        List<Transaction> transactions = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String line = bufferedReader.readLine(); //Ignore CSV header
            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                Transaction t = new Transaction(Double.parseDouble(values[0]), values[1], values[2], values[3], Timestamp.valueOf(values[4]));
                transactions.add(t);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    public static void writeCSV(String[] header, List<Transaction> transactions, String filename) throws IOException {
        PrintWriter file = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
        file.println(String.join(",", header));
        for (Transaction t : transactions) {
            String[] data = {Double.toString(t.value()), t.currency(), t.type(), t.category(), String.valueOf(t.timestamp())};
            file.println(String.join(",", data));
        }
        file.close();
    }
}
