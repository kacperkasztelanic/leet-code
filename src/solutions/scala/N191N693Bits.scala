package solutions.scala

object N191N693Bits {

  def hammingWeight(n: Int): Int = Integer.bitCount(n)

  def hasAlternatingBits(n: Int): Boolean = (n & (n >> 1)) == 0 && (n & (n >> 2)) == (n >> 2)

  def main(args: Array[String]): Unit = {
    assert(hammingWeight(11) == 3)
    assert(hammingWeight(128) == 1)
    assert(hammingWeight(0xFFFFFFFD) == 31)

    assert(hasAlternatingBits(5))
    assert(!hasAlternatingBits(7))
    assert(!hasAlternatingBits(11))
    assert(hasAlternatingBits(10))
  }
}
