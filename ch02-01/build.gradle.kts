project.description = "Simple project"

tasks {
  register("simple") {
    println("Running simple task for project: ${project.description}")
  }
}
