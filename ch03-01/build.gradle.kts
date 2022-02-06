val dir = project.file(File("config"), PathValidation.DIRECTORY)
val combined = files("README", java.net.URI("file:/README"))

tasks {
  register("filterFiles") {
    val rootFiles = files("INSTALL.txt", "README")
    val smallFiles = rootFiles.filter {
      it.name.endsWith("txt")
    }

    println("smallFiles = ${smallFiles.joinToString()}")
  }
}
