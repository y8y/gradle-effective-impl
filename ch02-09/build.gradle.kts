import java.util.Calendar.*

tasks {
  register("first") {
    println("Running ${this.name}")

    doFirst {
      val today = getInstance()
      val workingHours = today[HOUR_OF_DAY] in 8..17
      if (workingHours) {
        println("IN workingHours")
        throw StopExecutionException()
      }

      println("after workingHours")
    }
  }

  register("second") {
    dependsOn("first")

    println("Running ${this.name}")
  }
}
