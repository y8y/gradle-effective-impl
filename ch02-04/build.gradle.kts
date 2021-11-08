defaultTasks = listOf("third")

val myGroup = "ch02"

fun printTaskName (task: Task) {
  println("Run ${task.name}")
}

tasks {
  register("first") {
    setGroup(myGroup)
    setDescription("第一个任务")
    // println("Run ${this.name}")
    printTaskName(this)
  }

  register("second") {
    setGroup(myGroup)
    dependsOn("first")

    doLast {
      println("Run ${this.name}")
    }
  }

  register("third") {
    setGroup(myGroup)
    dependsOn("second")

    doLast {
      println("Run ${this.name}")
    }
  }
}
