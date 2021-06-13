package CountStrictly

import org.apache.spark.SparkConf


import org.apache.spark.SparkContext

import org.apache.spark.rdd.RDD.rddToPairRDDFunctions

object count {
  def main(args : Array[String]) = {
    
    val conf = new SparkConf().setAppName("CountChecker").setMaster("local")
   
    val sc = new SparkContext(conf)
    
    val lines = sc.textFile("book.txt")
    val data = lines.flatMap(x => x.toString.toLowerCase().split(" "))
    val mappedwords = data.countByValue();
      
    val results = mappedwords.filter(x => x._2>4)
    val sortedRes = results.toSeq.sortBy(_._2).reverse
     sortedRes.foreach(println)
    
    
  }
}