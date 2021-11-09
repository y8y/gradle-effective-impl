tasks {
  register("first") {
    description = "First task"
  }

  register("second") {
    description = "Second task"
  }

  addRule("Pattern: desc<TaskName>: show description of a task.") {
    if (this.startsWith("desc")) {
      val targetTaskName = this.drop(4)
      val targetTaskNameUncap = targetTaskName[0].toLowerCase().toString() + targetTaskName.drop(1)
      println("targetTaskNameUncap = $targetTaskNameUncap")

      val targetTask = project.tasks.findByName(targetTaskNameUncap)
      if (targetTask != null) {
        register(this) {
          doLast {
            println("Description of task ${targetTask.name} -> ${targetTask.description}")
          }
        }
      }
    }
  }
}
