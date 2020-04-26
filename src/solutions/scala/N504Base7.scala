package solutions.scala

import scala.annotation.tailrec

object N504Base7 {

  def convertToBase7(num: Int): String = {
    val radix = 7

    @tailrec
    def convert(n: Int, acc: List[Int]): String = n match {
      case 0 =>
        if (num < 0) '-' + acc.mkString
        else acc.mkString
      case n => convert(n / radix, Math.abs(n % radix) :: acc)
    }

    if (num != 0) convert(num, Nil)
    else "0"
  }

  def main(args: Array[String]): Unit = {
    assert(convertToBase7(100) == "202")
    assert(convertToBase7(-7) == "-10")
  }
}
