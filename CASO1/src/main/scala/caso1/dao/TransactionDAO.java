package caso1.dao;

import caso1.entities.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TransactionDAO {

    private static final Logger LOGGER = Logger.getLogger(TransactionDAO.class.getName());
    private Connection connection;

    public TransactionDAO(Connection connection) {
        this.connection = connection;
    }

    public Integer saveTransactions(String table, List<Transaction> transactions) {
        String sql = "INSERT INTO " + table + " (value,currency,category,created) VALUES(?, ?, ?,?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            connection.setAutoCommit(false);

            for (int i = 0; i < transactions.size(); i++) {
                statement.setDouble(1, transactions.get(i).value());
                statement.setString(2, transactions.get(i).currency());
                statement.setString(3, transactions.get(i).category());
                statement.setTimestamp(4, transactions.get(i).timestamp());
                statement.addBatch();
                if (i % 10000 == 0) {
                    statement.executeBatch();
                    connection.commit();
                }
            }
            statement.executeBatch();
            connection.commit();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, ex.getMessage(), ex);
            return -1;
        }
        return 1;
    }

    public List<Transaction> getTransactionsOfType(String type) throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        PreparedStatement preparedStatement = connection.prepareStatement("Select * from " + type.toLowerCase());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            double value = resultSet.getDouble("value");
            String currency = resultSet.getString("currency");
            String category = resultSet.getString("category");
            Timestamp timestamp = resultSet.getTimestamp("created");
            transactions.add(new Transaction(value, currency, type, category, timestamp));
        }
        return transactions;
    }
}
