package eu.proteus.solma.comparison

import org.apache.spark.ml.regression.LinearRegression
import org.apache.spark.sql.SparkSession

class SLOG {
  def main(args: Array[String]): Unit = {

    val spark = SparkSession
      .builder
      .appName("LassoRegression")
      .getOrCreate()

    // Load training data
    val training = spark.read.format("libsvm")
      .load("data/mllib/sample_linear_regression_data.txt")

    // Use ml.regression.LinearRegression with elasticNetParam = 1.0. Note the default regParam is 0.01 for LassoWithSGD, but is 0.0 for LinearRegression.", "2.0.0")

    val lr = new LinearRegression()
      .setMaxIter(10)
      .setRegParam(0.01)
      .setElasticNetParam(1.0)

    // Fit the model
    val lrModel = lr.fit(training)

    // Print the coefficients and intercept for linear regression
    println(s"Coefficients: ${lrModel.coefficients} Intercept: ${lrModel.intercept}")

    // Summarize the model over the training set and print out some metrics
    val trainingSummary = lrModel.summary
    println(s"numIterations: ${trainingSummary.totalIterations}")
    println(s"objectiveHistory: [${trainingSummary.objectiveHistory.mkString(",")}]")
    trainingSummary.residuals.show()
    println(s"RMSE: ${trainingSummary.rootMeanSquaredError}")
    println(s"r2: ${trainingSummary.r2}")
  }
}
