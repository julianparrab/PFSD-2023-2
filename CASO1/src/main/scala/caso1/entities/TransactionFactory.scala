package caso1.entities

import caso1.csv.CsvWorker

import java.io.IOException
import java.text.SimpleDateFormat
import java.time.{Duration, Instant}
import scala.util.Random
import java.sql.Timestamp

case class TransactionFactory() {

  val random = new Random()
  def createTransactions(numberOfTransactions: Int): List[Transaction] = {
    val transactions : List[Transaction] = null
    val currency = List("USD", "COP", "EUR")
    val `type` = List("Expense", "Income")
    val expenseCategories = List("Bills", "Transportation", "Shopping", "Entertainment", "Food")
    val incomeCategories = List("Salary", "Selling", "Gifts", "Award")

    for (i_ <- 0 until numberOfTransactions) {
      val rCurrency = currency(random.nextInt(currency.length))
      var rValue = 0.0
      if (rCurrency eq "USD") rValue = random.nextDouble * 15
      if (rCurrency eq "COP") rValue = random.nextDouble * 50000 + 15000
      if (rCurrency eq "EUR") rValue = random.nextDouble * 10
      val rType = `type`(random.nextInt(`type`.length))
      var rCategory = ""
      if (rType eq "Income") rCategory = incomeCategories(random.nextInt(incomeCategories.length))
      if (rType eq "Expense") rCategory = expenseCategories(random.nextInt(expenseCategories.length))
      val randomEightMonthsAgo = Instant.now.minus(Duration.ofDays(random.nextInt(240)))
      val rTimestamp = Timestamp(randomEightMonthsAgo.toEpochMilli)
      val transaction = Transaction(rValue, rCurrency, rType, rCategory, rTimestamp)
      return transaction +: transactions
    }
    transactions
  }

  def createTransactionsFile(numberOfTransactions: Int): Unit = {
    try {
      val transactions = createTransactions(numberOfTransactions)
      val header = Array("Value", "Currency", "Type", "Category", "Created")
      val fileName = new SimpleDateFormat("yyyyMMddHHmmSS'.csv'").format(java.util.Date.from(Instant.now()))
      CsvWorker.writeCSV(header, transactions, s"csvs/$fileName")
    } catch {
      case e: IOException => e.printStackTrace()
    }
  }
}
