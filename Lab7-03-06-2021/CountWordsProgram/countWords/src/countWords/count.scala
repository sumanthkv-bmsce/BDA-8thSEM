package countWords

import org.apache.spark.SparkConf


import org.apache.spark.SparkContext


import org.apache.spark.rdd.RDD.rddToPairRDDFunctions


object count {
  def main(args: Array[String]) = {
    
    val conf = new SparkConf().setAppName("CountWords").setMaster("local")
    
   val sc = new SparkContext(conf)
    
    val textFile = sc.textFile("Words.txt")
    val counts = textFile.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey(_ + _)
    import scala.collection.immutable.ListMap
    val sorted=ListMap(counts.collect.sortWith(_._2 > _._2):_*)// sort in descending order based on values
    println(sorted)
    for((k,v)<-sorted)
    {
      if(v>4)
        {
         print(k+",")
           print(v)
           println()
         }
    }
      
    }
}