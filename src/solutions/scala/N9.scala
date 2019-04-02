package solutions.scala

object N9 extends App {

  def isPalindrome(x: Int): Boolean = {
    x.toString.reverse.filter(Character.isDigit).toLong == x
  }

  def isPalindrome2(x: Int): Boolean = {
    if (x < 0 || (x % 10 == 0 && x != 0)) {
      return false
    }
    var copy = x
    var reverted = 0
    while (copy > reverted) {
      reverted = reverted * 10 + copy % 10
      copy = copy / 10
    }
    copy == reverted || copy == reverted / 10
  }

  println(isPalindrome(-2147483648))
  println(isPalindrome2(-2147483648))
  println(isPalindrome(92929))
  println(isPalindrome2(92929))
}
