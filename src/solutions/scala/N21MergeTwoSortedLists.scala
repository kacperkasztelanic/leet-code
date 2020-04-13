package solutions.scala

import scala.annotation.tailrec

object N21MergeTwoSortedLists {

  def mergeTwoLists(l1: List[Int], l2: List[Int]): List[Int] = {
    @tailrec
    def mergeTwoLists(ll1: List[Int], ll2: List[Int], acc: List[Int]): List[Int] = {
      (ll1, ll2) match {
        case (Nil, Nil) => acc
        case (a, Nil) => acc ::: a
        case (Nil, b) => acc ::: b
        case (h1 :: t1, h2 :: t2) =>
          if (h1 < h2) mergeTwoLists(t1, h2 :: t2, acc ::: List(h1))
          else mergeTwoLists(h1 :: t1, t2, acc ::: List(h2))
      }
    }

    mergeTwoLists(l1, l2, Nil)
  }

  case class ListNode(var x: Int = 0, var next: ListNode = null)

  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
    @tailrec
    def append(ll1: ListNode, ll2: ListNode, head: ListNode): ListNode = {
      if (ll1 == null) ll2
      else if (ll1.next == null) {
        ll1.next = ll2
        head
      }
      else append(ll1.next, ll2, head)
    }

    @tailrec
    def mergeTwoLists(ll1: ListNode, ll2: ListNode, acc: ListNode): ListNode = {
      if (ll1 == null && ll2 == null) acc
      else if (ll1 != null && ll2 == null) append(acc, ll1, acc)
      else if (ll1 == null && ll2 != null) append(acc, ll2, acc)
      else {
        if (ll1.x < ll2.x) mergeTwoLists(ll1.next, ll2, append(acc, ListNode(ll1.x), acc))
        else mergeTwoLists(ll1, ll2.next, append(acc, ListNode(ll2.x), acc))
      }
    }

    mergeTwoLists(l1, l2, null)
  }

  def main(args: Array[String]): Unit = {
    println(mergeTwoLists(List(1, 5, 10), List(4, 5, 11, 12)))
    println(mergeTwoLists(ListNode(1, ListNode(5, ListNode(10))), ListNode(4, ListNode(5, ListNode(11, ListNode(12))))))
  }
}
