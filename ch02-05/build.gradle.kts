tasks {
  register("one") {
    doFirst {
      // action
      println("Running ${this.name}")
    }
  }

  register("two") {
    doLast {
      // action
      println("Running ${this.name}")
    }
  }

  register("three") {
    // configuration
    println("Running ${this.name}")
  }
}
