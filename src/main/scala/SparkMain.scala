/**
  * Created by phejman on 28/09/16.
  */
import org.apache.spark.sql.{SparkSession, Strategy}
import org.apache.spark.sql.catalyst.plans.logical.{LogicalPlan, Project}
import org.apache.spark.sql.execution.{SparkPlan, SparkStrategy}



object SparkMain {

  val spark = SparkSession.builder().getOrCreate()


  object TestStrategy extends SparkStrategy {
    override def apply(plan: LogicalPlan): Seq[SparkPlan] = {
      println("JESTEM TUTAJ")
      Nil
    }
  }

  spark.experimental.extraStrategies =  Seq(TestStrategy)

}
