import java.util.Calendar.*

tasks {
  register("first") {
    println("Running ${this.name}")

    doFirst {
      val today = getInstance()
      val workingHours = today[HOUR_OF_DAY] in 8..17
      if (workingHours) {
        println("IS workingHours")
        throw StopExecutionException()
      } else {
        println("IS NOT workingHours")
      }
    }
  }

  register("second") {
    dependsOn("first")

    println("Running ${this.name}")
  }
}
