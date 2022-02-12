plugins {
  application
}

tasks {
  register<Copy>("example") {
    // 原文件树
    val sources = fileTree("src")
    println("(1)" + sources.files.joinToString())

    sources.visit {
      if (this.isDirectory) {
        println("(1.1) Directory: ${this.path}")
      } else {
        println("(1.2) File: ${this.path}, size: ${this.size}")
      }
    }

    // 将过滤结果赋予一个新的变量
    val javaFiles = sources.matching {
      include("**/*.java")
    }
    println("(2)" + javaFiles.files.joinToString())

    // 原地过滤
    sources.include("**/*.txt")
    println("(3)" + sources.files.joinToString())
  }

  register<Zip>("archiveTest") {
    from("src")
    into("files")
    archiveFileName.set("dist-files-archive-1.0-sample.zip")
    destinationDirectory.set(layout.buildDirectory.dir("dists"))
    println("in archiveTest 1")

    doFirst {
      println("in archiveTest 2")
    }
  }

  ext {
    this.set("customString", "custom")
    this.set("customInt", 101)
  }

  register("showProperties") {
    println("customString = ${ext.get("customString")}")
    println("customInt = ${ext.get("customInt")}")
  }
}

repositories {
  mavenCentral()
}

dependencies {
  // implementation(files("lib/panshi-tenant-manager-1.0-SNAPSHOT.jar"))
  implementation(fileTree("lib/tmp") {include("**/*.jar")})
  // implementation(fileTree("lib/tmp") {include("**/*.class")})
}
