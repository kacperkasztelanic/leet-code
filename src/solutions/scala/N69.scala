package solutions.scala

object N69 extends App {

  def sqrt(x: Int): Int = {
    def isGoodEnough(guess: Double, x: Double): Boolean =
      Math.abs(guess * guess - x) < 0.0001

    def improve(guess: Double, x: Double): Double =
      (guess + x / guess) * 0.5

    def sqrt(guess: Double, x: Double): Double =
      if (isGoodEnough(guess, x)) guess
      else sqrt(improve(guess, x), x)

    sqrt(1, x).toInt
  }

  println(sqrt(9))
}
