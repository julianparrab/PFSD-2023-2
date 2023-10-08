package caso1

import caso1.csv.CsvWorker
import caso1.dao.TransactionDAO
import caso1.entities.{Account, Transaction}

import java.io.IOException
import java.sql.SQLException
import java.util

class RepositoryIntegrationTest {

  @throws[SQLException]
  private[co] def readCsv_InsertPostgres(): Unit = {
    val transactionDAO = new TransactionDAO(RepositoryIntegrationTest.datasource.getConnection)
    try {
      val output = CsvWorker.readFile("csvs/transactions.csv")
      val outputIncomeTransactions = Transaction.getTransactionsOfType(output, "Income")
      val outputExpenseTransactions = Transaction.getTransactionsOfType(output, "Expense")
      // TODO In Scala, how would you do this better?
      transactionDAO.saveTransactions("Income", outputIncomeTransactions)
      transactionDAO.saveTransactions("Expense", outputExpenseTransactions)
      val storedIncomeTransactions = transactionDAO.getTransactionsOfType("Income")
      val storedExpenseTransactions = transactionDAO.getTransactionsOfType("Expense")
      assert(storedIncomeTransactions.size == outputIncomeTransactions.size)
      assert(storedExpenseTransactions.size == outputExpenseTransactions.size)
      val storedTransactions = new util.ArrayList[Transaction]
      storedTransactions.addAll(storedIncomeTransactions)
      storedTransactions.addAll(storedExpenseTransactions)
      val account = new Account(storedTransactions)
      assert(account.getCopTransactionsBalance == 4985960.1)
    } catch {
      case e: IOException =>
        System.out.println("Read error occurred.")
        e.printStackTrace()
    }
  }
}
