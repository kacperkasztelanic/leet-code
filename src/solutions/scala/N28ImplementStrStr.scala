package solutions.scala

import scala.annotation.tailrec

object N28ImplementStrStr {

  def strStr(haystack: String, needle: String): Int = {
    @tailrec
    def strStr(haystack: String, i: Int): Int = {
      if (haystack.length >= needle.length) {
        if (needle.head == haystack.head && haystack.substring(0, needle.length) == needle) i
        else strStr(haystack.tail, i + 1)
      }
      else -1
    }

    if (needle.length == 0) 0
    else strStr(haystack, 0)
  }

  def main(args: Array[String]): Unit = {
    assert(strStr("hello", "ll") == 2)
    assert(strStr("aaaaa", "bba") == -1)
  }
}
