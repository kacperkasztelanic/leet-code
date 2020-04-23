package solutions.scala

import scala.annotation.tailrec

object N71SimplifyPath {

  def simplifyPath(path: String): String = {
    @tailrec
    def simplifyPath(tokens: List[String], deque: List[String]): String = tokens match {
      case Nil => "/" + deque.reverse.mkString("/")
      case h :: t =>
        h match {
          case "" | "." => simplifyPath(t, deque)
          case ".." => simplifyPath(t, deque.drop(1))
          case _ => simplifyPath(t, h :: deque)
        }
    }

    simplifyPath(path.split("/").toList, Nil)
  }

  def simplifyPathVector(path: String): String = {
    @tailrec
    def simplifyPathVector(tokens: List[String], deque: Vector[String]): String = tokens match {
      case Nil => "/" + deque.mkString("/")
      case h :: t =>
        h match {
          case "" | "." => simplifyPathVector(t, deque)
          case ".." => simplifyPathVector(t, deque.dropRight(1))
          case _ => simplifyPathVector(t, deque :+ h)
        }
    }

    simplifyPathVector(path.split("/").toList, Vector())
  }

  def main(args: Array[String]): Unit = {
    assert(simplifyPath("/home/") == "/home")
    assert(simplifyPath("/../") == "/")
    assert(simplifyPath("/home//foo/") == "/home/foo")
    assert(simplifyPath("/a/../../b/../c//.//") == "/c")
    assert(simplifyPath("/a//b////c/d//././/../") == "/a/b/c")
  }
}
