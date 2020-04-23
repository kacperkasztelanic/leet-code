package solutions.scala

object N692TopKFrequentWords {

  def topKFrequent(words: Array[String], k: Int): List[String] = {
    words.groupBy(identity).mapValues(_.length).toSeq.sortBy(x => (-x._2, x._1)).take(k).map(_._1).toList
  }

  def topKFrequent2(words: Array[String], k: Int): List[String] = {
    val map: Map[String, Int] = words.groupBy(identity).mapValues(_.length)
    map.keys.toList.sortBy(v => (-map(v), v)).take(k)
  }

  def main(args: Array[String]): Unit = {
    assert(topKFrequent2(Array("i", "love", "leetcode", "i", "love", "coding"), 2) == List("i", "love"))
    assert(topKFrequent2(Array("the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"), 4)
      == List("the", "is", "sunny", "day"))
  }
}
