package solutions.scala

import scala.annotation.tailrec

object N17PhoneNumber {

  private val mnem: Map[Char, List[Char]] = Map(
    '2' -> "ABC",
    '3' -> "DEF",
    '4' -> "GHI",
    '5' -> "JKL",
    '6' -> "MNO",
    '7' -> "PQRS",
    '8' -> "TUV",
    '9' -> "WXYZ"
  ).mapValues(_.toLowerCase().toList).withDefaultValue(Nil)

  def letterCombinations(digits: String): List[String] = {
    def letterCombinations(digits: List[Char], current: List[Char], acc: List[String]): List[String] = digits match {
      case Nil => current.reverse.mkString :: acc
      case h :: t => mnem(h).flatMap(l => letterCombinations(t, l :: current, acc))
    }

    if (digits.nonEmpty) letterCombinations(digits.toList, Nil, Nil)
    else Nil
  }

  def letterCombinations2(digits: String): List[String] = {
    @tailrec
    def letterCombinations2(digits: List[Char], acc: List[String]): List[String] = digits match {
      case Nil => acc
      case h :: t => letterCombinations2(t, acc.flatMap(x => mnem(h).map(y => x + y)))
    }

    if (digits.nonEmpty) letterCombinations2(digits.toList, List(""))
    else Nil
  }

  def main(args: Array[String]): Unit = {
    assert(letterCombinations2("111").toSet == Set.empty)
    assert(letterCombinations2("").toSet == Set.empty)
    assert(letterCombinations2("23").toSet == List("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf").toSet)
  }
}
