package solutions.scala

import scala.annotation.tailrec

object N20N32Parentheses {

  def validParentheses(s: String): Boolean = {
    val opening = Set('(', '[', '{')
    val equivalences = Map(')' -> '(', ']' -> '[', '}' -> '{')

    @tailrec
    def validParentheses(l: List[Char], stack: List[Char]): Boolean = l match {
      case Nil => stack.isEmpty
      case h :: t =>
        if (opening.contains(h)) validParentheses(t, h :: stack)
        else if (stack.nonEmpty && equivalences(h) == stack.head) validParentheses(t, stack.tail)
        else false
    }

    validParentheses(s.toList, Nil)
  }

  def longestValidParentheses(s: String): Int = {
    @tailrec
    def longestValidParentheses(l: List[Char], stack: List[Int], n: Int, maxLength: Int): Int = l match {
      case Nil => maxLength
      case h :: t =>
        if (h == '(') longestValidParentheses(t, n :: stack, n + 1, maxLength)
        else {
          if (stack.tail.isEmpty) longestValidParentheses(t, n :: stack.tail, n + 1, maxLength)
          else longestValidParentheses(t, stack.tail, n + 1, Math.max(maxLength, n - stack.tail.head))
        }
    }

    longestValidParentheses(s.toList, List(-1), 0, 0)
  }

  def simpleBrackets(s: String): Boolean = {
    def bracketValue(b: Char): Int = b match {
      case '(' => 1
      case ')' => -1
      case _ => 0
    }

    @tailrec
    def simpleBrackets(l: List[Char], n: Int): Boolean = (l, n) match {
      case (_, _) if n < 0 => false
      case (Nil, nn) => nn == 0
      case (h :: t, nn) => simpleBrackets(t, nn + bracketValue(h))
    }

    simpleBrackets(s.toList, 0)
  }
}
