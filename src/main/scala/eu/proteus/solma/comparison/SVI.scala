package eu.proteus.solma.comparison

import org.apache.spark.{SparkConf, SparkContext}
//import splash.clustering._
//
object SVI {
  def main(args: Array[String]) {
    val docwordPath = args(0)
    val vocabPath = args(1)
    val sc = new SparkContext(new SparkConf().setAppName("SVI").setMaster("local"))

    // LDA parameters
    val numIterations = 20
    val numTopics = 20
    val alpha = 5.0 / numTopics
    val beta = 0.1
    println("Numumber of Iterations = " + numIterations)
    println("Numumber of Topics = " + numTopics)
    println("(alpha,beta) = " + (alpha, beta))

    // read the document-word table from file
//    val corpus = sc.textFile(docwordPath).map( x => {
//      val tokens = x.split(" ")
//      val docId = tokens(0).toInt - 1
//      val wordId = tokens(1).toInt - 1
//      val wordFreq = tokens(2).toInt
//      val topicId = Random.nextInt(numTopics)
//      (docId, new WordToken(wordId, wordFreq, Array.fill(wordFreq)(topicId)))
//    }).groupByKey().mapValues(x => x.toArray).repartition(8).cache()
//    println("Num of Documents = " + corpus.count())
//
//    // read the vocabulary from file
//    val vocab = new HashMap[Int, String]
//    val voc_array = sc.textFile(vocabPath).collect()
//    var index = 0
//    for(line <- voc_array){
//      vocab.put(index, line)
//      index += 1
//    }
//    val vocSize = vocab.size
//    println("Vocabulary Size = " + vocSize)
//
//    // train LDA using collapsed Gibbs sampling
//    val model = new splash.clustering.LDA
//    model.setNumTopics(numTopics).setAlphaBeta((alpha,beta)).setNumIterations(numIterations).train(corpus)
//
//    // view topics and their top words
//    val topicsMatrix = model.topicsMatrix
//    for(topicId <- 0 until numTopics){
//      val wordProb = new ListBuffer[(Int,Double)]
//      for(wordId <- 0 until vocSize) wordProb.append((wordId, topicsMatrix(wordId)(topicId)))
//      val sortedWordProb = wordProb.sortWith( (a,b) => a._2 > b._2 )
//
//      // output top words
//      println()
//      print("Topic " + (topicId+1) + ": ")
//      for(i <- 0 until 20) print(vocab(sortedWordProb(i)._1) + " ")
//    }
  }
}