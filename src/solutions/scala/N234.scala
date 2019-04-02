package solutions.scala

object N234 extends App {

  //Generic with case classes
  sealed trait GenericListNode[+A]

  case object Empty extends GenericListNode[Nothing]

  case class Node[+A](value: A, next: GenericListNode[A]) extends GenericListNode[A]

  def isPalindrome[A](head: Node[A]): Boolean = {
    var left = head

    def isPalindromeInternal(right: GenericListNode[A]): Boolean = {
      right match {
        case Empty => true
        case r: Node[A] => {
          if (!isPalindromeInternal(r.next)) {
            return false
          }
          val res = left.value == r.value
          left.next match {
            case l: Node[A] => left = l
            case _ => Unit
          }
          res
        }
      }
    }

    isPalindromeInternal(head)
  }

  val l1 = Node(1, Node(2, Empty))
  val l2 = Node(1, Node(2, Node(3, Node(2, Node(1, Empty)))))

  println(isPalindrome(l1))
  println(isPalindrome(l2))


  // Built in List
  def isPalindrome[A](list: List[A]): Boolean = {
    var left = list

    def isPalindromeInternal(right: List[A]): Boolean = {
      right match {
        case Nil => true
        case r =>
          if (isPalindromeInternal(r.tail)) {
            val res = left.head == r.head
            left match {
              case _ :: t => left = t
              case _ => Unit
            }
            res
          } else {
            false
          }
      }
    }

    isPalindromeInternal(list)
  }

  val ll1 = List(1, 2)
  val ll2 = List(1, 2, 3, 2, 1)

  println(isPalindrome(ll1))
  println(isPalindrome(ll2))

  // LeetCode ListNode
  class ListNode(var _x: Int = 0) {
    var next: ListNode = _
    var x: Int = _x
  }

  // StackOverflowError
  def isPalindrome(head: ListNode): Boolean = {
    var left = head

    def isPalindromeInternal(right: ListNode): Boolean = {
      right match {
        case null => true
        case r: ListNode =>
          if (isPalindromeInternal(r.next)) {
            val res = left.x == r.x
            left = left.next
            res
          }
          else {
            false
          }
      }

    }

    isPalindromeInternal(head)
  }


  def isPalindrome2(head: ListNode): Boolean = {
    if (head == null || head.next == null) {
      return true
    }
    // Get the head of the second half list.
    var sndListHead = getSecondHalfListHead(head)

    // Reverse second half list.
    sndListHead = reverse(sndListHead)

    // Compare with the original.
    var ptr = head
    while (sndListHead != null) {
      if (ptr.x != sndListHead.x) {
        return false
      }
      ptr = ptr.next
      sndListHead = sndListHead.next
    }

    true
  }

  def reverse(head: ListNode): ListNode = {
    if (head == null || head.next == null) {
      return head
    }
    var reversedHead: ListNode = null
    var toInsert = head
    while (toInsert != null) {
      val nextToInsert = toInsert.next
      toInsert.next = reversedHead
      reversedHead = toInsert
      toInsert = nextToInsert
    }
    reversedHead
  }

  def getSecondHalfListHead(head: ListNode): ListNode = {
    if (head == null || head.next == null) {
      return head
    }
    var slow = head
    var fast = head
    while (fast != null && fast.next != null) {
      fast = fast.next.next
      slow = slow.next
    }
    if (fast != null) {
      slow = slow.next
    }
    slow
  }
}
