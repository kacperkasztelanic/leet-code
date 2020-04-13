package solutions.scala

import scala.annotation.tailrec

object N168N171ExcelColumn {

  def getIndex(s: String): Int = {
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

  def getLetters(n: Int): String = {
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

  def main(args: Array[String]): Unit = {
    val indexTests = Map("A" -> 1, "Z" -> 26, "AA" -> 27, "ZZ" -> 702, "AAA" -> 703, "BZW" -> 2051, "CAA" -> 2055, "DZA" -> 3381)
    lazy val letterTests = for ((k, v) <- indexTests) yield (v, k)

    indexTests.foreach(e => println(N168N171ExcelColumn.getIndex(e._1) == e._2))
    letterTests.foreach(e => println(N168N171ExcelColumn.getLetters(e._1) == e._2))
  }
}
