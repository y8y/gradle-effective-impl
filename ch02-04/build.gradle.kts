val myGroup = "ch02"

fun printTaskName (task: Task) {
  println("Run ${task.name}")
}

tasks {
  register("first") {
    group = myGroup
    description = "第一个任务"
    // println("Run ${this.name}")
    printTaskName(this)
  }

  register("second") {
    group = myGroup
    dependsOn("first")

    doLast {
      println("Run ${this.name}")
    }
  }

  register("third") {
    group = myGroup
    dependsOn("second")
    dependsOn(listOf("deployToDev", "deployToAcc"))

    doLast {
      println("Run ${this.name}")
    }
  }

  listOf("Dev", "Acc", "Prod").forEach{
    register("deployTo${it}") {
      println("Deploying to $it")
    }
  }
}

defaultTasks("third")
