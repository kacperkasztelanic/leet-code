package solutions.scala

import scala.annotation.tailrec

object N69Sqrtx {

  def sqrt(x: Int): Int = {
    def isGoodEnough(guess: Double, x: Double): Boolean = abs(guess * guess - x) < 1

    def improve(guess: Double, x: Double): Double = (guess + x / guess) * 0.5

    def abs(x: Double): Double = if (x >= 0) x else -x

    @tailrec
    def sqrt(guess: Double, x: Double): Double =
      if (isGoodEnough(guess, x)) guess
      else sqrt(improve(guess, x), x)

    sqrt(1, x).toInt
  }
}
