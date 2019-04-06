package solutions.scala

import scala.annotation.tailrec

object Parentheses extends App {

  def simpleBrackets(s: String): Boolean = {
    def bracketValue(b: Char): Int = {
      b match {
        case '(' => 1
        case ')' => -1
        case _ => 0
      }
    }

    @tailrec
    def simpleBrackets(l: List[Char], n: Int): Boolean = {
      (l, n, n < 0) match {
        case (_, _, true) => false
        case (Nil, nn, _) => nn == 0
        case (h :: t, nn, _) => simpleBrackets(t, nn + bracketValue(h))
      }
    }

    simpleBrackets(s.toList, 0)
  }

  def validParentheses(s: String): Boolean = {
    val opening = Set('(', '[', '{')
    val equivalences = Map(')' -> '(', ']' -> '[', '}' -> '{')

    @tailrec
    def validParentheses(l: List[Char], stack: List[Char]): Boolean = {
      l match {
        case Nil => stack.isEmpty
        case h :: t =>
          if (opening.contains(h)) validParentheses(t, h :: stack)
          else if (stack.nonEmpty && equivalences(h) == stack.head) validParentheses(t, stack.tail)
          else false
      }
    }

    validParentheses(s.toList, Nil)
  }

  println(validParentheses("({({})([])})"))
  println(validParentheses("]"))

  def longestValidBrackets(s: String): Int = {
    @tailrec
    def longestValidBrackets(l: List[Char], stack: List[Int], n: Int, maxLength: Int): Int = {
      l match {
        case Nil => maxLength
        case h :: t =>
          if (h == '(') longestValidBrackets(t, n :: stack, n + 1, maxLength)
          else {
            if (stack.tail.isEmpty) longestValidBrackets(t, n :: stack.tail, n + 1, maxLength)
            else longestValidBrackets(t, stack.tail, n + 1, Math.max(maxLength, n - stack.tail.head))
          }
      }
    }

    longestValidBrackets(s.toList, List(-1), 0, 0)
  }

  println(longestValidBrackets("())(())"))
  println(longestValidBrackets(")()())"))
}
