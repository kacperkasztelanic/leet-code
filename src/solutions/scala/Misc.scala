package solutions.scala

object Misc extends App {

  def isIsogram(s: String): Boolean = {
    s.toCharArray.toSet.size == s.length
  }

  println(isIsogram("isogram"))
  println(isIsogram("notisogram"))
}
