package eci.edu.co.functions

object Currying {

  def sumNotCurried(a: Int, b: Int, c: Int): Int = a + b + c

  def sumCurried(a: Int): Int => Int => Int = (b: Int) => (c: Int) => a + b + c

}
