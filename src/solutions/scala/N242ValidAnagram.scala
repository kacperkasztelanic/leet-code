package solutions.scala

object N242ValidAnagram {

  def isAnagram(s: String, t: String): Boolean = {
    val fun = (a: String) => a.groupBy(identity).mapValues(_.length)
    fun(s) == fun(t)
  }

  def isAnagram2(s: String, t: String): Boolean = s.sorted.equals(t.sorted)

  def main(args: Array[String]): Unit = {
    assert(isAnagram2("anagram", "nagaram"))
    assert(!isAnagram("rat", "car"))
    assert(isAnagram("anagram", "nagaram"))
    assert(!isAnagram2("rat", "car"))
  }
}
