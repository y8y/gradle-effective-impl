import java.io.File

tasks {
  register("listDir") {
    val dir = File("assemble")
    this.enabled = dir.exists()

    doLast {
      println("List directory contents: ${dir.listFiles().joinToString()}}")
    }
  }
}
