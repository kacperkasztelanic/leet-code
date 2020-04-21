package solutions.scala

import scala.annotation.tailrec

object N344ReverseString {

  def reverseString(s: Array[Char]): Unit = {
    @tailrec
    def reverseString(start: Int): Unit = {
      if (start < s.length / 2) {
        val temp = s(s.length - start - 1)
        s(s.length - start - 1) = s(start)
        s(start) = temp
        reverseString(start + 1)
      }
    }

    reverseString(0)
  }

  def reverseString2(s: Array[Char]): Unit = {
    @tailrec
    def reverseString2(start: Int, end: Int): Unit = {
      if (start < end) {
        val temp = s(end)
        s(end) = s(start)
        s(start) = temp
        reverseString2(start + 1, end - 1)
      }
    }

    reverseString2(0, s.length - 1)
  }

  def main(args: Array[String]): Unit = {
    val arr = "Hello".toCharArray
    reverseString(arr)
    println(arr.mkString)
  }
}
