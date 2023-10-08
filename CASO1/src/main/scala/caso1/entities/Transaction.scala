package caso1.entities

import Transaction._

import java.sql.Timestamp

case class Transaction(value: Double, currency: String, `type`: String = "", category: String, timestamp: Timestamp) {

  def this (currency: String, `type`: String, category: String, timestamp: Timestamp) = {
    this(0, currency, `type`, category, timestamp)
  }

  var listTransactions = List(this)

  //def valueInCop = calculateValueInCop(currency, value)

  //def valueInCopT = calculateValueInCop(this)

  def transactionsOfType = getTransactionsOfType(listTransactions, `type`)
  def transactionsOfCurrency = getTransactionsOfCurrency(listTransactions, currency)
  def sumTransOfType  = sumTransactionsOfType(listTransactions, `type`)
  def printTransaction: Unit = println(toString)

  override def toString: String = s"Value: $value, Currency: $currency, Type: ${`type`}"

}

object Transaction {

  import scala.util.Random

  val COP = "COP"
  val CLP = "CLP"
  val USD = "USD"
  val EUR = "EUR"
  val GBP = "GBP"
  val JPY = "JPY"
  val Currencies = List(COP, USD, EUR, GBP, JPY)

  val USD_COP = 4098
  val EUR_COP = 4455
  val GBP_COP = 5210
  val JPY_COP = 28

  val Income = "Income"
  val Expense = "Expense"
  val Types = List(Income, Expense)

  val random = new Random()

  val Bills = "Bills"
  val Transportation = "Transportation"
  val Shopping = "Shopping"
  val Entertainment = "Entertainment"
  val Food = "Food"
  val ExpenseCategories = List(Bills,Transportation, Shopping, Entertainment, Food)

  val Salary = "Salary"
  val Selling = "Selling"
  val Gifts = "Gifts"
  val Award = "Award"
  val IncomeCategories = List(Salary, Selling, Gifts, Award)

  val Categories = List(IncomeCategories, ExpenseCategories)

  def getValue(transaction: Transaction): Double = {
    transaction.value
  }

  def getCurrency(transaction: Transaction): String = {
    transaction.currency
  }

  def getType(transaction: Transaction): String = {
    transaction.`type`
  }

  def getCategory(transaction: Transaction): String = {
    transaction.category
  }

  def getTimestamp(transaction: Transaction): Timestamp = {
    transaction.timestamp
  }

  def getTransactionsOfType(transactions: List[Transaction], `type`: String): List[Transaction] = {
    val typeTransactions = List[Transaction]()
    for (t <- transactions) {
      if (t.`type` == `type`) return t :: typeTransactions
    }
    typeTransactions
  }

  def getTransactionsOfCurrency(transactions: List[Transaction], currency: String): List[Transaction] = {
    val currencyTransactions = Nil
    for (t <- transactions) {
      if (t.currency == currency) return t +: currencyTransactions
    }
    currencyTransactions
  }

  def sumTransactionsOfType(transactions: List[Transaction], `type`: String): Double = {
    var sum = 0
    for (t <- transactions) {
      if (t.`type` == `type`) sum += t.value
    }
    sum
  }
}
