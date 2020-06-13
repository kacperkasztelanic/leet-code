package solutions.scala

import scala.annotation.tailrec

object N150EvaluateReversePolishNotation {

  def evalRPN(tokens: Array[String]): Int = {
    @tailrec
    def evalRPN(tokens: List[String], s: List[Int]): Int = tokens match {
      case Nil => s.head
      case h :: t => h match {
        case "+" => evalRPN(t, (s.tail.head + s.head) :: s.tail.tail)
        case "-" => evalRPN(t, (s.tail.head - s.head) :: s.tail.tail)
        case "*" => evalRPN(t, (s.tail.head * s.head) :: s.tail.tail)
        case "/" => evalRPN(t, (s.tail.head / s.head) :: s.tail.tail)
        case _ => evalRPN(t, h.toInt :: s)
      }
    }

    evalRPN(tokens.toList, Nil)
  }

  def evalRPN2(tokens: Array[String]): Int = {
    def evalRPN2(tokens: List[String], s: List[Int]): Int = tokens match {
      case Nil => s.head
      case h :: t =>
        val eval: ((Int, Int) => Int) => Int = f => evalRPN2(t, f(s.tail.head, s.head) :: s.tail.tail)
        h match {
          case "+" => eval(_ + _)
          case "-" => eval(_ - _)
          case "*" => eval(_ * _)
          case "/" => eval(_ / _)
          case _ => evalRPN2(t, h.toInt :: s)
        }
    }

    evalRPN2(tokens.toList, Nil)
  }

  def evalRPN3(tokens: Array[String]): Int = {
    tokens.foldLeft(List.empty[Int]) {
      case (s, token) => token match {
        case "+" => s.tail.head + s.head :: s.tail.tail
        case "-" => s.tail.head - s.head :: s.tail.tail
        case "*" => s.tail.head * s.head :: s.tail.tail
        case "/" => s.tail.head / s.head :: s.tail.tail
        case _ => token.toInt :: s
      }
    }.head
  }

  def main(args: Array[String]): Unit = {
    assert(evalRPN3(Array("2", "1", "+", "3", "*")) == 9)
    assert(evalRPN3(Array("4", "13", "5", "/", "+")) == 6)
    assert(evalRPN3(Array("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+")) == 22)
  }
}
