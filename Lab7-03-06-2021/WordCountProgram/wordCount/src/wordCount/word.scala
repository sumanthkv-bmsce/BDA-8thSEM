package wordCount

import org.apache.spark.SparkConf


import org.apache.spark.SparkContext


import org.apache.spark.rdd.RDD.rddToPairRDDFunctions


object WordCount {

 
def main(args: Array[String]) = {


   
   val conf = new SparkConf().setAppName("WordCount").setMaster("local")


   
   val sc = new SparkContext(conf)


 


   
//Read some example file to a test RDD


   
val test = sc.textFile("Words.txt")


 


   
test.flatMap { line => line.split(" ") }


     
.map {
word => 


        (word, 1) 


     
}


     
.reduceByKey(_ + _) //Sum all of the value with same key


     
.saveAsTextFile("output.txt") //Save to a text file


sc.stop


 
}


}