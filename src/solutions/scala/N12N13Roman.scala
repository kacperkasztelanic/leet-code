package solutions.scala

import scala.annotation.tailrec
import scala.collection.immutable.ListMap

object N12N13Roman {

  private val fromRomanMap: Map[String, Int] = ListMap(
    "M" -> 1000, "CM" -> 900,
    "D" -> 500, "CD" -> 400,
    "C" -> 100, "XC" -> 90,
    "L" -> 50, "XL" -> 40,
    "X" -> 10, "IX" -> 9,
    "V" -> 5, "IV" -> 4,
    "I" -> 1
  ).withDefaultValue(0)

  private lazy val toRomanMap: Map[Int, String] = for ((k, v) <- fromRomanMap) yield (v, k)

  def intToRoman(n: Int): String = {
    def findRoman(n: Int): (Int, String) = {
      toRomanMap.find(n - _._1 >= 0).map(e => (n - e._1, e._2)).getOrElse((n, ""))
    }

    @tailrec
    def intToRoman(n: Int, acc: List[Char]): List[Char] = {
      if (n <= 0) acc
      else {
        val found = findRoman(n)
        intToRoman(found._1, acc ::: found._2.toList)
      }
    }

    intToRoman(n, Nil).mkString
  }

  def romanToInt(s: String): Int = {
    @tailrec
    def romanToInt(l: List[Char], acc: Int): Int = l match {
      case Nil => acc
      case _ :: Nil => acc + fromRomanMap(l.mkString)
      case _ => fromRomanMap.get(l.slice(0, 2).mkString) match {
        case Some(v) => romanToInt(l.slice(2, l.size), acc + v)
        case None => romanToInt(l.tail, acc + fromRomanMap(l.head.toString))
      }
    }

    romanToInt(s.toList, 0)
  }
}
