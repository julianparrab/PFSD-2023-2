package eci.edu.co.functions

object PureFunctions {

  def square(x: Int): Int = x * x

  def sum1(x: Int): Int = x + 1

  def sum2(x: Int): Int = x + 2

  def sayHello(): Unit = {
    println("Hello!")
  }

  def sumPure(a: Int, b: Int) = a + b

  def sumImpure(a: Int, b: Int) = {
    sayHello()
    a + b
  }

}
