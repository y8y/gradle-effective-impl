tasks {
  register("numbers") {
    (1..4).forEach { number ->
      val squared = number * number
      println("Square of $number = $squared")
    }
  }

  register("list") {
    val list = listOf("Groovy", "Gradle", "Kotlin")
    println(list.joinToString(separator = "&") {
      it.toLowerCase()
    })
  }
}
