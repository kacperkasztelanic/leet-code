package solutions.scala

import scala.annotation.tailrec

object N917ReverseOnlyLetters {

  def reverseOnlyLetters(input: String): String = {
    @tailrec
    def reverseOnlyLetters(arr: Array[Char], i: Int, j: Int): Array[Char] = {
      if (i >= j) arr
      else (arr(i).isLetter, arr(j).isLetter) match {
        case (true, true) =>
          val temp = arr(i)
          arr(i) = arr(j)
          arr(j) = temp
          reverseOnlyLetters(arr, i + 1, j - 1)
        case (false, true) => reverseOnlyLetters(arr, i + 1, j)
        case (true, false) => reverseOnlyLetters(arr, i, j - 1)
        case _ => reverseOnlyLetters(arr, i + 1, j - 1)
      }
    }

    reverseOnlyLetters(input.toCharArray, 0, input.length - 1).mkString
  }

  def main(args: Array[String]): Unit = {
    assert(reverseOnlyLetters("ab-cd") == "dc-ba")
    assert(reverseOnlyLetters("a-bC-dEf-ghIj") == "j-Ih-gfE-dCba")
    assert(reverseOnlyLetters("Test1ng-Leet=code-Q!") == "Qedo1ct-eeLg=ntse-T!")
  }
}
