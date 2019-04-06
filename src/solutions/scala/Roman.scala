package solutions.scala

import scala.annotation.tailrec
import scala.collection.immutable.ListMap

object Roman extends App {

  val fromRomanConversions = ListMap(
    "M" -> 1000, "CM" -> 900, "D" -> 500, "CD" -> 400,
    "C" -> 100, "XC" -> 90, "L" -> 50, "XL" -> 40,
    "X" -> 10, "IX" -> 9, "V" -> 5, "IV" -> 4,
    "I" -> 1)

  val toRomanConversions = for ((k, v) <- fromRomanConversions) yield (v, k)

  def toRoman(n: Int): String = {
    def findRoman(n: Int): (Int, String) = {
      toRomanConversions.find(n - _._1 >= 0).map(e => (n - e._1, e._2)).getOrElse((n, ""))
    }

    @tailrec
    def toRoman(n: Int, acc: List[Char]): List[Char] = {
      if (n <= 0) acc
      else {
        val found = findRoman(n)
        toRoman(found._1, acc ::: found._2.toList)
      }
    }

    toRoman(n, Nil).mkString
  }

  def fromRoman(s: String): Int = {
    def findInt(r: String): Option[Int] = {
      fromRomanConversions.find(_._1 == r).map(_._2)
    }

    @tailrec
    def fromRoman(l: List[Char], acc: Int): Int = {
      if (l == Nil) acc
      else if (l.size == 1) acc + findInt(l.mkString).getOrElse(0)
      else {
        findInt(l.slice(0, 2).mkString) match {
          case Some(v) => fromRoman(l.slice(2, l.size), acc + v)
          case None => fromRoman(l.tail, acc + findInt(l.head.toString).getOrElse(0))
        }
      }
    }

    fromRoman(s.toList, 0)
  }

  println(fromRoman(toRoman(2019)))
}
