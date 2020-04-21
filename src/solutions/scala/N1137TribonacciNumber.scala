package solutions.scala

import scala.annotation.tailrec
import scala.collection.mutable

object N1137TribonacciNumber {

  def tribonacci(n: Int): Int = {
    @tailrec
    def tribonacci(a: Int, b: Int, c: Int, n: Int): Int = n match {
      case 0 => a
      case 1 => b
      case 2 => c
      case _ => tribonacci(b, c, a + b + c, n - 1)
    }

    tribonacci(0, 1, 1, n)
  }

  def tribonacci2(n: Int): Int = {
    lazy val trib: Int => Int = memoize {
      case 0 => 0
      case 1 => 1
      case 2 => 1
      case n => trib(n - 1) + trib(n - 2) + trib(n - 3)
    }

    trib(n)
  }

  def memoize[I, O](f: I => O): I => O = new mutable.HashMap[I, O]() {
    self =>
    override def apply(key: I): O = self.synchronized(getOrElseUpdate(key, f(key)))
  }

  def tribonacci3(n: Int): Int = {
    if (n == 0) 0
    else if (n == 1 || n == 2) 1
    else tribonacci3(n - 1) + tribonacci3(n - 2) + tribonacci3(n - 3)
  }

  def main(args: Array[String]): Unit = {
    assert(tribonacci(4) == 4)
    assert(tribonacci(25) == 1389537)
    assert(tribonacci(37) == 2082876103)
  }
}
