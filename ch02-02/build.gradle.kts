tasks {
  register("first") {
    doFirst {
      println("Running first")
    }
  }

  register("second") {
    doLast {
      println("Running second")
    }
  }

  register("third") {
    doLast {
      println("Running third")
    }
  }
}
