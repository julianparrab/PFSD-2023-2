package eci.edu.co.functions

object HigherOrderFunctions {

  def applyFunc(x: Int, func: Int => Int): Int = func(x)

  def mathOperation(operator: String): (Int, Int) => Int = {
    operator match {
      case "+" => (a: Int, b: Int) => a + b
      case "-" => (a: Int, b: Int) => a - b
      case "*" => (a: Int, b: Int) => a * b
      case "/" => (a: Int, b: Int) => a / b
      case _ => (a: Int, b: Int) => 0
    }
  }

}
