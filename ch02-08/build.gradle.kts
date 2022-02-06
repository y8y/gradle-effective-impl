import java.io.File
val fileName = "data.sample"
var file = File(fileName)

tasks {
  register("first") {
    onlyIf {
      val exist = file.exists()
      if (!exist) {
        file.createNewFile()
      }
      return@onlyIf !exist
    }

    doLast {
      println("Work with file $fileName")
    }
  }
}
