package solutions.scala

object N100 extends App {

  sealed trait Tree[+A]

  case object Empty extends Tree[Nothing]

  case class Node[+A](elem: A, left: Tree[A], right: Tree[A]) extends Tree[A]

  def isSameTree[A](p: Tree[A], q: Tree[A]): Boolean =
    (p, q) match {
      case (Empty, Empty) => true
      case (_, Empty) => false
      case (Empty, _) => false
      case (a: Node[A], b: Node[A]) => a.elem == b.elem && isSameTree(a.left, b.left) && isSameTree(a.right, b.right)
    }

  def isSymmetric[A](root: Tree[A]): Boolean = {
    def isSymmetric(p: Tree[A], q: Tree[A]): Boolean =
      (p, q) match {
        case (Empty, Empty) => true
        case (Empty, _) => false
        case (_, Empty) => false
        case (p: Node[A], q: Node[A]) => p.elem == q.elem && isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left)
      }

    root match {
      case Empty => true
      case a: Node[A] => isSymmetric(a.left, a.right)
    }
  }

  val a1 = Node(1, Node(2, Empty, Empty), Node(3, Empty, Empty))
  val b1 = Node(1, Node(2, Empty, Empty), Node(3, Empty, Empty))
  val a2 = Node(1, Node(2, Empty, Empty), Empty)
  val b2 = Node(1, Empty, Node(2, Empty, Empty))
  val a3 = Node(1, Node(2, Empty, Empty), Node(3, Empty, Empty))
  val b3 = Node(1, Node(3, Empty, Empty), Node(2, Empty, Empty))
  println(isSameTree(a1, b1))
  println(isSameTree(a2, b2))
  println(isSameTree(a3, b3))


  val s1 = Node(1, Node(2, Node(3, Empty, Empty), Node(4, Empty, Empty)), Node(2, Node(4, Empty, Empty), Node(3, Empty, Empty)))
  val s2 = Node(1, Node(2, Empty, Node(3, Empty, Empty)), Node(2, Empty, Node(3, Empty, Empty)))
  println(isSymmetric(s1))
  println(isSymmetric(s2))

  class TreeNode(var _value: Int) {
    var value: Int = _value
    var left: TreeNode = null
    var right: TreeNode = null
  }


  def isSymmetric(root: TreeNode): Boolean = {
    def isSymmetric(p: TreeNode, q: TreeNode): Boolean =
      if (p == null && q == null) true
      else if (p == null || q == null) false
      else p.value == q.value && isSymmetric(p.left, q.right) &&
        isSymmetric(p.right, q.left)

    if (root == null) true
    else isSymmetric(root.left, root.right)
  }
}
