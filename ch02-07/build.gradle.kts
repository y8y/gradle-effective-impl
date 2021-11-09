import java.util.Calendar.*

tasks {
  register("longrunning") {
    onlyIf {
      val now = getInstance()
      val weekDay = now[DAY_OF_WEEK]
      return@onlyIf weekDay in arrayOf(TUESDAY, SATURDAY, SUNDAY)
    }

    doLast {
      println("Do long running stuff")
    }
  }
}
