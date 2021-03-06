import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

buildscript {
  repositories {
    mavenCentral()
  }

  dependencies {
    classpath("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.1")
  }
}

data class Person(val name: String, val email: String)

val mapper = jacksonObjectMapper()

tasks {
  register("convert") {
    val source = File("${project.rootDir}/ch02-11/source.json")
    val output = File("${project.rootDir}/ch02-11/output.txt")

    this.inputs.file(source)
    // this.outputs.file(output)
    this.outputs.upToDateWhen {
      File("${project.rootDir}/ch02-11").listFiles().any {
        it.name.equals("output.txt")
      }
    }

    val students = mapper.readValue<Array<Person>>(source.readBytes())

    doLast {
      output.printWriter().use { writer ->
        for (s in students) {
          writer.println("${s.name}, ${s.email}")
        }
      }

      println("Converted ${source.name} to ${output.name}")
    }
  }

  register("last") {
    dependsOn("convert")

    // ch03-01 测试
    val outputFiles = files(getConvertTask().inputs.files)
    println("=== outputFiles 1 = ${(outputFiles + files("test.txt")).joinToString()} ===")
    println("=== outputFiles 2 = ${(outputFiles + files("test.txt")).asPath} ===")
  }
}

fun getConvertTask(): Task {
  return tasks.getByName("convert")
}
