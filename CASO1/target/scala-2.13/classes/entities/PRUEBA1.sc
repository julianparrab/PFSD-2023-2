
import entities.Transaction
import entities.Transaction.getTransactionsOfType

val date = "2023/11/22T10:10:10"


val t1 = Transaction(1.0, Transaction.USD, Transaction.Income, Transaction.Salary, date)
val t2 = Transaction(26.0, Transaction.USD, Transaction.Income, Transaction.Selling, date)
val t3 = Transaction(5.0, Transaction.EUR, Transaction.Expense, Transaction.Selling, date)
val t4 = Transaction(300000, Transaction.COP, Transaction.Expense, Transaction.Selling, date)
val t5 = Transaction(300000, Transaction.COP, Transaction.Income, Transaction.Selling, date)
val t6 = Transaction(14, Transaction.GBP, Transaction.Income, Transaction.Selling, date)
val t7 = Transaction(356, Transaction.JPY, Transaction.Income, Transaction.Selling, date)

val transactionList = List(t1, t2, t3, t4, t5, t6, t7)

//test("distinctBy transactions by value") {
  val uniqueTransactionsExpected = List(t1, t2, t3, t4, t6, t7)
  // TODO Implement
  //val uniqueTransactions: List[Transaction] = uniqueTransactionsExpected.distinctBy(t => t.value)
  //assert(uniqueTransactions == uniqueTransactionsExpected)

//val a = Transaction.getValue(t1)
//val b = getTransactionsOfType(transactionList,Transaction.Income)
