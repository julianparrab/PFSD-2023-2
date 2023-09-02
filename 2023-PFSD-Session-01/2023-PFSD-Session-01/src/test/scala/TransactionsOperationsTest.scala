import eci.edu.co.{Transaction, TransactionFactory, TransactionsOperations}
import org.scalatest.FunSuite

import scala.jdk.CollectionConverters._

class TransactionsOperationsTest extends FunSuite {
  val t1 = new Transaction(1.0, "USD", "Income")
  val t2 = new Transaction(3.0, "USD", "Income")
  val t3 = new Transaction(8.0, "EUR", "Expense")
  val t4 = new Transaction(20000.0, "COP", "Expense")
  val t5 = new Transaction(20000.0, "COP", "Expense")

  val transactions1 = List(t1, t2, t3)
  val transactions2 = List(t4)
  val transactions3 = List(t1, t2, t3, t4, t5)
  val transactions4 = List(t2, t3, t4, t5)


  test("Test join") {
    val transactionsJoined = TransactionsOperations.join(transactions1.asJava, transactions2.asJava).asScala
    assert(transactions1 ++ transactions2 === transactionsJoined)
  }

  test("Test min") {
    val minTransaction = TransactionsOperations.min(transactions1.asJava)
    assert(t1 === minTransaction)
  }

  test("Test Distinct") {
    val distinctTransactions = TransactionsOperations.distinct(transactions3.asJava).asScala
    assert(distinctTransactions.length === 4)
  }

  test("Test add") {
    val transactionsAdded = TransactionsOperations.add(t1, transactions2.asJava).asScala
    assert(transactionsAdded.length === 2)
  }

  test("Test head") {
    val head = TransactionsOperations.head(transactions3.asJava)
    assert(head === t1)
  }

  test("Test tail") {
    val tail = TransactionsOperations.tail(transactions3.asJava)
    assert(tail.asScala === transactions4)
  }

  test("Test max") {
    val maxTransaction = TransactionsOperations.max(transactions3.asJava)
    assert(maxTransaction === t3)
  }


}
