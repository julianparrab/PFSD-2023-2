package caso1.entities

abstract case class Account() {

  val transactions : List[Transaction]
  def getCopTransactions: List[Transaction] = Transaction.getTransactionsOfCurrency(transactions, "COP")

  def getCopIncomeTransactions: List[Transaction] = Transaction.getTransactionsOfType(getCopTransactions, "Income")

  def getCopIncomeTransactionsValue: Double = Transaction.sumTransactionsOfType(getCopIncomeTransactions, "Income")

  def getCopExpenseTransactions: List[Transaction] = Transaction.getTransactionsOfType(getCopTransactions, "Expense")

  def getCopExpenseTransactionsValue: Double = Transaction.sumTransactionsOfType(getCopExpenseTransactions, "Expense")

  def getCopTransactionsBalance: Double = getCopIncomeTransactionsValue - getCopExpenseTransactionsValue

  def getUsdTransactions: List[Transaction] = Transaction.getTransactionsOfCurrency(transactions, "USD")

  def getUsdIncomeTransactions: List[Transaction] = Transaction.getTransactionsOfType(getUsdTransactions, "Income")

  def getUsdIncomeTransactionsValue: Double = Transaction.sumTransactionsOfType(getUsdIncomeTransactions, "Income")

  def getUsdExpenseTransactions: List[Transaction] = Transaction.getTransactionsOfType(getUsdTransactions, "Expense")

  def getUsdExpenseTransactionsValue: Double = Transaction.sumTransactionsOfType(getUsdExpenseTransactions, "Expense")

  def getUsdTransactionsBalance: Double = getUsdIncomeTransactionsValue - getUsdExpenseTransactionsValue

  def getEurTransactions: List[Transaction] = Transaction.getTransactionsOfCurrency(transactions, "COP")

  def getEurIncomeTransactions: List[Transaction] = Transaction.getTransactionsOfType(getEurTransactions, "Income")

  def getEurIncomeTransactionsValue: Double = Transaction.sumTransactionsOfType(getEurIncomeTransactions, "Income")

  def getEurExpenseTransactions: List[Transaction] = Transaction.getTransactionsOfType(getEurTransactions, "Expense")

  def getEurExpenseTransactionsValue: Double = Transaction.sumTransactionsOfType(getEurExpenseTransactions, "Expense")

  def getEurTransactionsBalance: Double = getEurIncomeTransactionsValue - getEurExpenseTransactionsValue

}
