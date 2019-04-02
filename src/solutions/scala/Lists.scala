package solutions.scala

import scala.annotation.tailrec

object Lists extends App {

  def findMiddle[A](list: List[A]): List[A] = {
    @tailrec
    def findMiddle(fast: List[A], slow: List[A]): List[A] =
      if (fast == Nil || fast.tail == Nil) slow
      else findMiddle(fast.tail.tail, slow.tail)

    findMiddle(list, list)
  }

  def findMiddlePm[A](list: List[A]): List[A] = {
    @tailrec
    def findMiddle(fast: List[A], slow: List[A]): List[A] = (fast, slow) match {
      case (Nil, s) => s
      case (f, s) => (f.tail, s) match {
        case (Nil, st) => st
        case (ft, st) => findMiddle(ft.tail, st.tail)
      }
    }

    findMiddle(list, list)
  }

  def reverse[A](list: List[A]): List[A] = {
    list match {
      case Nil => Nil
      case h :: t => reverse(t) ++ List(h)
    }
  }

  def printBackwards[A](list: List[A]): Unit = {
    if (list != Nil) {
      printBackwards(list.tail)
      println(list.head)
    }
  }

  val l1 = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
  val l2 = List(1, 2, 3, 4, 5, 6, 7, 8, 9)
  println(findMiddle(l1))
  println(findMiddle(l2))
  println(reverse(findMiddle(l1)))
  println(reverse(l2))
  printBackwards(l1)
}
