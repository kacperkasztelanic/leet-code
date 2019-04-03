package solutions.scala.excel

import scala.annotation.tailrec

object ExcelColumnsImpl extends ExcelColumns {

  override def getIndex(s: String): Int = {
    val numericValue = (c: Char) => c.getNumericValue - 9
    val multiplier = 'Z' - 'A' + 1

    @tailrec
    def getIndex(s: List[Char], acc: Int): Int = {
      s match {
        case Nil => acc
        case h :: t => getIndex(t, acc * multiplier + numericValue(h))
      }
    }

    getIndex(s.toList, 0)
  }

  override def getLetters(n: Int): String = {
    @tailrec
    def getLetters(n: Int, acc: List[Char]): List[Char] = {
      if (n == 0) acc
      else {
        val quotient = (n - 1) / 26
        val remainder = (n - 1) % 26
        getLetters(quotient, (65 + remainder).toChar :: acc)
      }
    }

    getLetters(n, Nil).mkString
  }
}
