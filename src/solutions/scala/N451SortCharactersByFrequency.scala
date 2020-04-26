package solutions.scala

object N451SortCharactersByFrequency {

  def frequencySort(s: String): String = {
    s.groupBy(identity).mapValues(_.length).toSeq.sortBy(-_._2).flatMap(t => List.fill(t._2)(t._1)).mkString
  }
}
