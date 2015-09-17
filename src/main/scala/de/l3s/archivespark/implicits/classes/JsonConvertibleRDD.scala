package de.l3s.archivespark.implicits.classes

import de.l3s.archivespark.utils.JsonConvertible
import org.apache.spark.rdd.RDD

/**
 * Created by holzmann on 17.09.2015.
 */
class JsonConvertibleRDD[Record <: JsonConvertible](rdd: RDD[Record]) {
  def toJson = rdd.map(r => r.toJson)

  def toJsonStrings = rdd.map(r => r.toJsonString)

  def saveAsJson(path: String) = toJsonStrings.saveAsTextFile(path)
}
