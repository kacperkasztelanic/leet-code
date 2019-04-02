package solutions.scala

import scala.annotation.tailrec

object ExcelIndex extends App {

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
    ""
  }

  val getIndexTests = Map("A" -> 1, "Z" -> 26, "AA" -> 27, "ZZ" -> 702, "AAA" -> 703, "BZW" -> 2051, "CAA" -> 2055, "DZA" -> 3381)
  val getLettersTests = for ((k, v) <- getIndexTests) yield (v, k)

  getIndexTests.foreach(e => println(getIndex(e._1) == e._2))
  getLettersTests.foreach(e => println(getLetters(e._1) == e._2))
}
