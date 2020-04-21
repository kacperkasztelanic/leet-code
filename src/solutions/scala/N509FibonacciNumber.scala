package solutions.scala

import scala.annotation.tailrec

object N509FibonacciNumber {

  def fib(n: Int): Int = {
    @tailrec
    def fib(a: Int, b: Int, n: Int): Int =
      if (n > 0) fib(b, a + b, n - 1)
      else a

    fib(0, 1, n)
  }

  def fib2(n: Int): Int = {
    if (n == 0 || n == 1) n
    else fib2(n - 1) + fib2(n - 2)
  }

  def main(args: Array[String]): Unit = {
    assert(fib(2) == 1)
    assert(fib(3) == 2)
    assert(fib(4) == 3)
  }
}
